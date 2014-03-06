package org.springframework.samples.petclinic.repository.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.samples.petclinic.model.Todo;

public interface TodoMapper {

	public List<Todo> findAll();
	
	public Todo findById(@Param("id") String id);

	public void insert(Todo todo);

	public void save(Todo todo);
	
	public void remove(String id);
	
}