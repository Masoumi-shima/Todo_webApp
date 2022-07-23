package com.todo.TodoWebApp.todoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TodoListService
{
    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListService(TodoListRepository todoListRepository)
    {
        this.todoListRepository = todoListRepository;
    }
    public void saveTask(TodoList todoList)
    {
        todoList.setCreationDate(Instant.now());
        todoListRepository.save(todoList);
    }
}
