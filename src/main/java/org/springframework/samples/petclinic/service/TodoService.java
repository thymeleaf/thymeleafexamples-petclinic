package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.samples.petclinic.model.Todo;

public interface TodoService {
	
	public List<Todo> findAll();

	public Todo findById(String id);

	public Todo create(Todo todo);

	public void update(Todo todo);

	public void remove(String id);

}
