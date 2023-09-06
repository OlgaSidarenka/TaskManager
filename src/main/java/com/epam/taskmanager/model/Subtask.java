package com.epam.taskmanager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Subtask {
	@Id
	private String id;

	public Subtask(String name, String description) {
		this.name = name;
		this.description = description;
	}

	private String name;
	private String description;
}
