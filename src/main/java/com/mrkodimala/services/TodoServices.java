package com.mrkodimala.services;

import com.mrkodimala.data.Todo;

import java.util.Date;
import java.util.List;

public interface TodoServices {

    void addNewTodo(String name,Date deliveryDate);

    List<Todo> getAllTodos();
}
