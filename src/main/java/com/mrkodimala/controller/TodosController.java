package com.mrkodimala.controller;

import com.mrkodimala.controller.data.TodoRequest;
import com.mrkodimala.data.Todo;
import com.mrkodimala.services.TodoServices;
import com.mrkodimala.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/{version}/todo")
public class TodosController {

    @Autowired
    private TodoServices todoServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Todo>>  getAllTodos(){
        List<Todo> todoList = todoServices.getAllTodos();
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addNewTodo(@RequestBody TodoRequest todoRequest){
        todoServices.addNewTodo(todoRequest.getName(),
                CommonUtils.getDateFromString(todoRequest.getDeliveryTime()));
        return new ResponseEntity<String>("Added Successfully",HttpStatus.OK);
    }
}

