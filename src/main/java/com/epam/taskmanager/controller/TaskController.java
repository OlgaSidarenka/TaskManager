package com.epam.taskmanager.controller;

import com.epam.taskmanager.model.Subtask;
import com.epam.taskmanager.model.Task;
import com.epam.taskmanager.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private  TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAll();
    }

    @GetMapping(value = "/overdue")
    public List<Task> getOverdueTasks() {
        return taskService.getOverdueTasks();
    }

    @GetMapping(value = "/category/{category}")
    public List<Task> getTasksByCategory(@PathVariable String category) {
        return taskService.getTasksByCategory(category);
    }

    @GetMapping(value = "/category/{category}/subtasks")
    public List<Subtask> getSubtasksByTaskCategory(@PathVariable String category) {
        return taskService.getSubTasksByTaskCategory(category);
    }

    @GetMapping(value = "/description/{word}")
    public List<Task> searchTasksByDescription(@PathVariable String word) {
        return taskService.searchByDescription(word);
    }

    @GetMapping(value = "/subtasks/name/{name}")
    public List<Task> searchBySubtaskName(@PathVariable String name) {
        return taskService.searchBySubtaskName(name);
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateTask(@PathVariable String id, @RequestBody Task task) {
        taskService.updateTask(id, task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> updateTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
