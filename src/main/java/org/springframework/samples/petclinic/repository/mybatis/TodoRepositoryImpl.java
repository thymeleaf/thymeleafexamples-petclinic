package org.springframework.samples.petclinic.repository.mybatis;

import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Todo;
import org.springframework.samples.petclinic.repository.TodoRepository;
import org.springframework.samples.petclinic.repository.mybatis.mapper.TodoMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

	@Autowired
    private TodoMapper todoMapper;
    
    static final Logger logger = LoggerFactory.getLogger(TodoRepositoryImpl.class);
    
    public Todo create(Todo todo) {
    	todoMapper.insert(todo);
         return todo;
    }
    
     public Todo update(Todo todo) {
         todoMapper.save(todo);
         return todo;
    }
    
    public Todo findById(String id) {
        return todoMapper.findById(id);
    }

    public List<Todo> findAll() {
        return todoMapper.findAll();
    }
    
    public void remove(String id) {
         todoMapper.remove(id);
    }
    
    public void removeAll() {
     
    	List<Todo> todos = todoMapper.findAll();
    	for (Iterator iterator = todos.iterator(); iterator.hasNext();) {
			Todo todo = (Todo) iterator.next();
			todoMapper.remove(todo.getId());
		}
         
    }
    
}
