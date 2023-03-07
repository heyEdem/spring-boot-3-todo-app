package com.edem.springboot3todoapp.services;

import com.edem.springboot3todoapp.model.TodoItem;
import com.edem.springboot3todoapp.repositories.TodoItemRepositories;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class TodoItemService {

    TodoItemRepositories todoItemRepositories;
    public TodoItemService(TodoItemRepositories todoItemRepositories) {
        this.todoItemRepositories = todoItemRepositories;
    }

    public Iterable<TodoItem> getAll(){
        return todoItemRepositories.findAll();
    }

    public Optional<TodoItem> getById(Long id){
        return todoItemRepositories.findById(id);
    }

    public TodoItem save (TodoItem todoItem){
        if (todoItem.getId() == null){
            todoItem.setCreatedAt(Instant.now());
        }

        todoItem.setUpdatedAt(Instant.now());
        return todoItemRepositories.save(todoItem);
    }

    public void delete (TodoItem todoItem){
        todoItemRepositories.delete(todoItem);
    }
}
