package com.todo.TodoWebApp.todoList;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
@Data
public class TodoList
{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    private String task;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}
