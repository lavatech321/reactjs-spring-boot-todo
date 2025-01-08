package com.lavatech.todo.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "todo_app")
public class ToDoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)  // Set task as NOT NULL
    private String task;

    @Column(nullable = false)  // Set task as NOT NULL
    private LocalDate task_date;

    @Column(nullable = false)
    private Boolean status = false; // Default value set to false

    public ToDoModel(long id, String task, LocalDate task_date, Boolean status) {
        this.id = id;
        this.task = task;
        this.task_date = task_date;
        this.status = status;
    }

    public ToDoModel() {
    }

    public long getId() {
        return this.id;
    }

    public String getTask() {
        return this.task;
    }

    public LocalDate getTask_date() {
        return this.task_date;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setTask_date(LocalDate task_date) {
        this.task_date = task_date;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
