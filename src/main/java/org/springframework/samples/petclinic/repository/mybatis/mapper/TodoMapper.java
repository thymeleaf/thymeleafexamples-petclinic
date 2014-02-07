package org.springframework.samples.petclinic.repository.mybatis.mapper;

import java.util.List;

import org.springframework.samples.petclinic.model.Todo;

public interface TodoMapper {

	public void insert(Todo todo);

	public void save(Todo todo);

	public Todo findById(String id, Class<Todo> class1);

	public List<Todo> findAll(Class<Todo> class1);

	public void remove(String id);

	public boolean collectionExists(Class<Todo> class1);

	public void dropCollection(Class<Todo> class1);

	public void createCollection(Class<Todo> class1);

}