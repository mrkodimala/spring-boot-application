package com.mrkodimala.services.impl;

import com.mrkodimala.data.User;
import com.mrkodimala.repository.UsersRepository;
import com.mrkodimala.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void addNewUser(String username,String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        usersRepository.save(user);
    }

    @Override
    public User getUserByUserName(String username) {
        return usersRepository.findByUsername(username);
    }
}
