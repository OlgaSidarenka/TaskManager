package com.epam.taskmanager;

import com.epam.taskmanager.model.Subtask;
import com.epam.taskmanager.model.Task;
import com.epam.taskmanager.repository.MongoDbTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class TaskManagerApplication {
@Autowired
	MongoDbTaskRepository mongoDbTaskRepository;
	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

}
