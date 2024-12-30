package com.lavatech.todo;

import java.time.LocalDate;
import com.lavatech.todo.model.ToDoModel;
import com.lavatech.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	@Autowired
	ToDoRepository toDoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
