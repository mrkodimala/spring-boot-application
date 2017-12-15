package com.mrkodimala.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrkodimala.authentication.data.LoginRequest;
import com.mrkodimala.data.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse){
        try {
            LoginRequest loginRequest = new ObjectMapper().readValue(
                    httpServletRequest.getInputStream(),LoginRequest.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),loginRequest.getPassword(),
                            new ArrayList<>()));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,FilterChain filterChain,
            Authentication authentication){

        String token = Jwts.builder()
                .setSubject(((User)authentication.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 86400))
                .signWith(SignatureAlgorithm.HS512,"secret")
                .compact();
        httpServletResponse.addHeader("Authorization", "Bearer " + token);
    }
}
