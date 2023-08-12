package com.edem.springboot3todoapp.services;


import com.edem.springboot3todoapp.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    Todo createTodo(Todo todo);

    List<Todo> getAllTodos();

    Optional<Todo> findTodoById(Long id);

    void deleteTodo(Long id);

}
