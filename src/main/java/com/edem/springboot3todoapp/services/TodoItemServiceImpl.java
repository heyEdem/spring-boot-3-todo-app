package com.edem.springboot3todoapp.services;

import com.edem.springboot3todoapp.model.Todo;
import com.edem.springboot3todoapp.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoService{

    private final TodoRepository repository;

    public TodoItemServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Todo createTodo(Todo todo) {
         return repository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Todo> findTodoById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteTodo(Long id) {
         repository.deleteById(id);
    }
//
//    TodoRepository todoItemRepositories;
//    public TodoItemServiceImpl(TodoRepository todoItemRepositories) {
//        this.todoItemRepositories = todoItemRepositories;
//    }
//
//    public Iterable<Todo> getAll(){
//        return todoItemRepositories.findAll();
//    }
//
//    public Optional<Todo> getById(Long id){
//        return todoItemRepositories.findById(id);
//    }
//
//    public Todo save (Todo todoItem){
//        if (todoItem.getId() == null){
//            todoItem.setCreatedAt(Instant.now());
//        }
//
//        todoItem.setUpdatedAt(Instant.now());
//        return todoItemRepositories.save(todoItem);
//    }
//
//    public void delete (Todo todoItem){
//        todoItemRepositories.delete(todoItem);
//    }
}
