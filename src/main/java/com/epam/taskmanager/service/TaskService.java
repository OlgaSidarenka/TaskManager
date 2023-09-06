package com.epam.taskmanager.service;

import com.epam.taskmanager.model.Subtask;
import com.epam.taskmanager.model.Task;

import java.util.List;

public interface TaskService {

    void saveTask(Task task);
    void updateTask(String id, Task task);
    void deleteTask(String id);
    List<Task> getAll();
    List<Task> getOverdueTasks();
    List<Task> getTasksByCategory(String category);
    List<Subtask> getSubTasksByTaskCategory(String category);
    List<Task> searchByDescription(String word);
    List<Task> searchBySubtaskName(String word);
}
