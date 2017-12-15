package com.mrkodimala.repository;

import com.mrkodimala.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<User,String>{
    User findByUsername(String username);
}
