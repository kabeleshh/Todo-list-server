package com.example.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.server.model.Todo;

@Repository
public interface RepoTodo extends JpaRepository<Todo,Integer> {
    
}
