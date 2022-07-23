package com.todo.TodoWebApp.todoList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoListConfig
{
    @Bean
    CommandLineRunner commandLineRunner(TodoListRepository todoListRepository)
    {
        return args ->
        {
            TodoList todoList = new TodoList(
                    "Test the first version of Todo app.",
                    Status.TODO
            );
            todoListRepository.save(todoList);
        };
    }
}
