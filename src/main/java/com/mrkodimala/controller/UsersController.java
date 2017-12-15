package com.mrkodimala.controller;

import com.mrkodimala.controller.data.SignUpRequest;
import com.mrkodimala.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/{version}/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/signup" , method = RequestMethod.GET)
    public ResponseEntity<String> signUpNewUser(@RequestBody SignUpRequest signUpRequest){
        if( StringUtils.isEmpty(signUpRequest.getUsername()) ||
                StringUtils.isEmpty(signUpRequest.getPassword())){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        usersService.addNewUser(signUpRequest.getUsername(),signUpRequest.getPassword());
        return new ResponseEntity<String>("You are Signedup successfully",HttpStatus.OK);
    }

}
