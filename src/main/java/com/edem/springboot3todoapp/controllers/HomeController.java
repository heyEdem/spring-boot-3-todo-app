package com.edem.springboot3todoapp.controllers;
import com.edem.springboot3todoapp.services.TodoItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    TodoItemService todoItemService;
    public HomeController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }


    @GetMapping("/error")
    public String errorPage(){
        return "You got another bug bro! Go fuck around and fix that!";
    }
}
