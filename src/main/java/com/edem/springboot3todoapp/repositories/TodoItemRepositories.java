package com.edem.springboot3todoapp.repositories;

import com.edem.springboot3todoapp.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepositories extends JpaRepository<TodoItem, Long> {
}
