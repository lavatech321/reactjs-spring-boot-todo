package com.lavatech.todo.repository;

import com.lavatech.todo.model.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;



public interface ToDoRepository extends JpaRepository<ToDoModel, Long> {

    List<ToDoModel> findByStatusFalse();
    List<ToDoModel> findByStatusTrue();
    void deleteByStatus(boolean status);

}
