package com.mrkodimala.services;

import com.mrkodimala.data.Todo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface TodoServices {

    void addNewTodo(String name,Date deliveryDate);

    List<Todo> getAllTodos();
}
