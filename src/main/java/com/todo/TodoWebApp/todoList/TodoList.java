package com.todo.TodoWebApp.todoList;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "todo_list")
@Data
@NoArgsConstructor
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

    @Enumerated(EnumType.STRING)
    private Status status;

    private Instant creationDate;
    private Instant modificationDate;

    public TodoList(String task, Status status)
    {
        this.task = task;
        this.status = status;
        this.creationDate = Instant.now();
        this.modificationDate = Instant.now();
    }
}
