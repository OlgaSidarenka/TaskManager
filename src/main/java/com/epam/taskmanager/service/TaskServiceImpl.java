package com.epam.taskmanager.service;

import com.epam.taskmanager.model.Subtask;
import com.epam.taskmanager.model.Task;
import com.epam.taskmanager.repository.MongoDbTaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    public MongoDbTaskRepository mongoDbTaskRepository;

//    public TaskServiceImpl(MongoDbTaskRepository mongoDbTaskRepository) {
//        this.mongoDbTaskRepository = mongoDbTaskRepository;
//    }

    @Override
    public void saveTask(Task task) {
        mongoDbTaskRepository.save(task);
    }

    @Override
    public void updateTask(String id, Task newTask) {
        mongoDbTaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot find task by provided id"));
        newTask.setId(id);
        mongoDbTaskRepository.save(newTask);
    }

    @Override
    public void deleteTask(String id) {
        mongoDbTaskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAll() {
        return mongoDbTaskRepository.findAll();
    }

    @Override
    public List<Task> getOverdueTasks() {
        return mongoDbTaskRepository.findByDeadlineBefore(LocalDateTime.now());
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return mongoDbTaskRepository.findByCategory(category);
    }

    @Override
    public List<Subtask> getSubTasksByTaskCategory(String category) {
        return mongoDbTaskRepository.findByCategory(category).stream()
                .flatMap(task -> task.getSubtasks().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> searchByDescription(String word) {
        return mongoDbTaskRepository.findByDescriptionContaining(word);
    }

    @Override
    public List<Task> searchBySubtaskName(String word) {
        return mongoDbTaskRepository.findBySubtaskNameContainingIgnoreCase(word);
    }

}
