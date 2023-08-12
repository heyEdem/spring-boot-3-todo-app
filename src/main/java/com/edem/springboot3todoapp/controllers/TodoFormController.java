//package com.edem.springboot3todoapp.controllers;
//import ch.qos.logback.core.model.Model;
//import com.edem.springboot3todoapp.model.Todo;
//import com.edem.springboot3todoapp.services.TodoItemServiceImpl;
//import jakarta.validation.Valid;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class TodoFormController {
//    private TodoItemServiceImpl todoItemService;
//
//    public TodoFormController(TodoItemServiceImpl todoItemService) {
//        this.todoItemService = todoItemService;
//    }
//
//    @GetMapping("/home")
//    public String home(Model model){
//
//        return "index";
//    }
//    @GetMapping("/create-todo")
//    public String showCreateForm(Todo todo){
//        return "new-todo-item";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteTodoItem(@PathVariable("id") Long id, Model model){
//        Todo todo = todoItemService.getById(id)
//                .orElseThrow(()-> new IllegalArgumentException("Todo item "+ id + " not found"));
//        todoItemService.delete(todo);
//        return "redirect:/";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String updateStudentForm(@PathVariable("id") Long id ,Model model){
//        Todo todo = todoItemService
//                .getById(id)
//                .orElseThrow(()-> new IllegalArgumentException("Todo item "+ id + " not found"));
//
//        //model.addAttribute("todo",todo);
//        return "edit-todo-item";
//    }
//
//    @PostMapping("/todo")
//    public String createTodoItem(@Valid Todo todo, BindingResult result, Model model){
//        Todo item = new Todo();
//        item.setDescription(todo.getDescription());
//        item.setIsComplete(todo.getIsComplete());
//
//        todoItemService.save(todo);
//        return "redirect:/";
//    }
//
//    @PostMapping("/todo/{id}")
//    public String updateTodoItem(@PathVariable("id") Long id, @Valid Todo todo, BindingResult result, Model model){
//        Todo item = todoItemService
//                .getById(id)
//                .orElseThrow(()-> new IllegalArgumentException("Todo item "+ id + " not found"));
//        item.setIsComplete(item.getIsComplete());
//        item.setDescription(item.getDescription());
//        todoItemService.save(item);
//        return "redirect:/";
//    }
//}
