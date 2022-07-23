package com.todo.TodoWebApp.todoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.List;

@Controller
public class TodoListController
{
    private final TodoListRepository todoListRepository;
    private final TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListRepository todoListRepository, TodoListService todoListService)
    {
        this.todoListRepository = todoListRepository;
        this.todoListService = todoListService;
    }

    @GetMapping({"/", "/todoList"})
    public ModelAndView getTodoList()
    {
        ModelAndView modelAndView = new ModelAndView("list");
        List<TodoList> list = todoListRepository.findAll();
        modelAndView.addObject("todoList", list);
        return modelAndView;
    }

    @GetMapping("/addTaskForm")
    public ModelAndView addTaskForm()
    {
        ModelAndView modelAndView = new ModelAndView("addTaskForm");
        TodoList list = new TodoList();
        modelAndView.addObject("todoList", list);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView updateTask(@PathVariable("id") String id, Model model)
    {
        TodoList list = todoListRepository.findById(id).get();
        list.setModificationDate(Instant.now());
        ModelAndView modelAndView = new ModelAndView("addTaskForm");
        modelAndView.addObject("todoList", list);
        return modelAndView;
    }

    @PostMapping("/saveTask")
    public ModelAndView saveTask(@Validated @ModelAttribute("todoList") TodoList list, BindingResult result)
    {
        if (result.hasErrors())
        {
            ModelAndView modelAndView = new ModelAndView("addTaskForm", HttpStatus.BAD_REQUEST);
            modelAndView.addObject("todoList", list);
            return modelAndView;
        }
        todoListService.saveTask(list);
        return new ModelAndView("redirect:/");
    }

    @GetMapping ("/delete/{id}")
    public ModelAndView deleteTask(@PathVariable("id") String id, Model model)
    {
        todoListRepository.deleteById(id);
        return new ModelAndView("redirect:/");
    }
}
