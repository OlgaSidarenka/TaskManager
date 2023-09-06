package com.epam.taskmanager.model;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
@Document(collection = "tasks")
public class Task {
    @Id
    @Generated
    private String id;

    private LocalDateTime dateOfCreation;

    public Task(LocalDateTime dateOfCreation, String name, String description, List<Subtask> subtasks, String category) {
        this.dateOfCreation = dateOfCreation;
        this.name = name;
        this.description = description;
        this.subtasks = subtasks;
        this.category = category;
    }

    private String name;
    private String description;
    private List<Subtask> subtasks;
    private String category;

    public void setId(String id) {
        this.id = id;
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }
}
