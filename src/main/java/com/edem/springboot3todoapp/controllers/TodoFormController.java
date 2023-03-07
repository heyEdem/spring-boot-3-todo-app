package com.edem.springboot3todoapp.controllers;
import ch.qos.logback.core.model.Model;
import com.edem.springboot3todoapp.model.TodoItem;
import com.edem.springboot3todoapp.services.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoFormController {
    private TodoItemService todoItemService;

    public TodoFormController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem){
        return "new-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model){
        TodoItem todoItem = todoItemService.getById(id)
                .orElseThrow(()-> new IllegalArgumentException("Todo item "+ id + " not found"));
        todoItemService.delete(todoItem);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateStudentForm(@PathVariable("id") Long id ,Model model){
        TodoItem todoItem = todoItemService
                .getById(id)
                .orElseThrow(()-> new IllegalArgumentException("Todo item "+ id + " not found"));

        //model.addAttribute("todo",todoItem);
        return "edit-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model){
        TodoItem item = new TodoItem();
        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());

        todoItemService.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model){
        TodoItem item = todoItemService
                .getById(id)
                .orElseThrow(()-> new IllegalArgumentException("Todo item "+ id + " not found"));
        item.setIsComplete(item.getIsComplete());
        item.setDescription(item.getDescription());
        todoItemService.save(item);
        return "redirect:/";
    }
}
