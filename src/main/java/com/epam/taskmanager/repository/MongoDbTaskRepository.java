package com.epam.taskmanager.repository;

import com.epam.taskmanager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MongoDbTaskRepository extends MongoRepository<Task, String> {
    List<Task> findByDeadlineBefore(LocalDateTime localDateTime);
    List<Task> findByCategory(String category);
    List<Task> findByDescriptionContaining(String word);
    @Query("{ 'subtasks.name' : { $regex: ?0, $options: 'i' } }")
    List<Task> findBySubtaskNameContainingIgnoreCase(String subtaskName);
}
