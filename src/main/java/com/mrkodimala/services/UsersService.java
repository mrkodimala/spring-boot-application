package com.mrkodimala.services;

import com.mrkodimala.data.User;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

    void addNewUser(String username, String password);

    User getUserByUserName(String username);
}
