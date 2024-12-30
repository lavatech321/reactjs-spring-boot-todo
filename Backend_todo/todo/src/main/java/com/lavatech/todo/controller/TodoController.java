package com.lavatech.todo.controller;


import com.lavatech.todo.TodoApplication;
import com.lavatech.todo.exception.ResourceNotFoundException;
import com.lavatech.todo.model.ToDoModel;
import com.lavatech.todo.repository.ToDoRepository;
import com.lavatech.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    ToDoRepository toDoRepository;

    @Autowired
    ToDoService toDoService;

    // Postman API testing
    // http://localhost:8060/api/v1/todo
    @GetMapping
    public List<ToDoModel> getAllTask(){
        return toDoRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<ToDoModel> getTaskById(@PathVariable Long id) {
        ToDoModel t1 = toDoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task does not exists"));
        return ResponseEntity.ok(t1);
    }

    // API for create
    // {
    //    "task" : "Cooking",
    //        "task_date": "2024-12-12",
    //        "status": false
    // }
    @PostMapping
    public ToDoModel createTask(@RequestBody ToDoModel t1) {
        return toDoRepository.save(t1);
    }

    @PutMapping("{id}")
    public ResponseEntity<ToDoModel> updateTask(@PathVariable Long id, @RequestBody ToDoModel t1) {
        ToDoModel updateTask = toDoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task does not exists"));
        updateTask.setTask(t1.getTask());
        updateTask.setTask_date(t1.getTask_date());
        updateTask.setStatus(t1.getStatus());
        toDoRepository.save(updateTask);
        return ResponseEntity.ok(updateTask);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id) {
        ToDoModel deleteTask = toDoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task does not exists"));
        toDoRepository.delete(deleteTask);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @GetMapping("status_pending")
    public List<ToDoModel> viewPending() {
        return toDoRepository.findByStatusFalse();
    }

    @GetMapping("status_complete")
    public List<ToDoModel> viewCompleted() {
        return toDoRepository.findByStatusTrue();
    }

    @DeleteMapping("/status_pending")
    public ResponseEntity<String> deletePending() {
        toDoService.deletePendingTask();
        return ResponseEntity.ok("All pending tasks have been deleted");
    }

    @DeleteMapping("/status_complete")
    public ResponseEntity<String> deleteComplete() {
        toDoService.deleteCompletedTask();
        return ResponseEntity.ok("All complete tasks have been deleted");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        toDoRepository.deleteAll();
        return ResponseEntity.ok("All tasks deleted successfully");
    }
}
