package com.todo.TodoWebApp.todoList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TodoListConfig
{
    @Bean
    CommandLineRunner commandLineRunner(TodoListRepository todoListRepository)
    {
        return args ->
        {
            TodoList todoList = new TodoList(
                    "Miriam",
                    Status.TODO
            );
            todoListRepository.save(todoList);
        };
    }
}
