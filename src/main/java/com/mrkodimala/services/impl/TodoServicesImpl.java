package com.mrkodimala.services.impl;

import com.mrkodimala.data.Todo;
import com.mrkodimala.repository.TodosRepository;
import com.mrkodimala.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TodoServicesImpl implements TodoServices {

    @Autowired
    private TodosRepository todosRepository;

    @Override
    public void addNewTodo(String name, Date deliveryDate) {
        Todo todo = new Todo();
        todo.setTodoName(name);
        todo.setCreateTime(new Date());
        todo.setDeliveryTime(new Date());
        todosRepository.insert(todo);
    }

    @Override
    public List<Todo> getAllTodos(){
        return todosRepository.findAll();
    }
}
