package com.example.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.server.model.Todo;
import com.example.server.repository.RepoTodo;

@Service
public class ServiceTodo {
    
    @Autowired
    private RepoTodo repoTodo;

    public ServiceTodo(RepoTodo repoTodo){
        this.repoTodo = repoTodo;
    }

    public List<Todo> getAllList(){
        return repoTodo.findAll();
    }

    public Todo setNew(Todo todo){
        return repoTodo.save(todo);
    }

    public Todo updateTodo(int id, Todo todo){
        Todo actual = repoTodo.findById(id).orElseThrow();
        // actual.setList(todo.getList());
        actual.setCompleted(todo.isCompleted());
        // actual.setCategory(todo.getCategory());
        // actual.setPriority(todo.getPriority());
        return repoTodo.save(actual);
    }

    public boolean delTodo(int id){
        if(repoTodo.existsById(id)){
            repoTodo.deleteById(id);
            return true;
        }
        return false;
    }
}
