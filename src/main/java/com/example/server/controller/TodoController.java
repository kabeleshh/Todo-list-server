package com.example.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.model.Todo;

import com.example.server.service.ServiceTodo;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private ServiceTodo serviceTodo;

    public TodoController(ServiceTodo serviceTodo){
        this.serviceTodo = serviceTodo;
    }
    
    @GetMapping("/get")
    public List<Todo> getList(){
        return serviceTodo.getAllList();
    }

    @PostMapping("/new")
    public Todo newTodo(@RequestBody Todo todo){
        return serviceTodo.setNew(todo);
    }

    @PatchMapping("/completed/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo){
        return serviceTodo.updateTodo(id, todo);
    }

    @DeleteMapping("/del/{id}")
    public String deleteTodo(@PathVariable int id){
        return serviceTodo.delTodo(id)?" Deleted Successfully ":" Resource not found to delete ";
    }
}
