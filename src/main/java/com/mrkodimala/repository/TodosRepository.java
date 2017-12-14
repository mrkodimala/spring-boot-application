package com.mrkodimala.repository;

import com.mrkodimala.data.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface TodosRepository extends MongoRepository<Todo,String> {

}
