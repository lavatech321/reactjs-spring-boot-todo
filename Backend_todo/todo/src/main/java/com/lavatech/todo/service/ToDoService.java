package com.lavatech.todo.service;


import com.lavatech.todo.repository.ToDoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Transactional
    public void deletePendingTask() {
        toDoRepository.deleteByStatus(false);
    }

    @Transactional
    public void deleteCompletedTask(){
        toDoRepository.deleteByStatus(true);
    }
}
