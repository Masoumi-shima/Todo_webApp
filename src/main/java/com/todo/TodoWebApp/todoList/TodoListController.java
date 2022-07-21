package com.todo.TodoWebApp.todoList;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoListController
{
    private TodoListRepository todoListRepository;

    @GetMapping({"/", "/todoList"})
    public ModelAndView getTodoList()
    {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", todoListRepository);
        return modelAndView;
    }
}
