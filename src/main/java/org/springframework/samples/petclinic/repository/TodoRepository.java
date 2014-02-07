
package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.samples.petclinic.model.Todo;

public interface TodoRepository {

    public Todo create(Todo todo);
    
    public Todo update(Todo todo);
    
    public Todo findById(String id);

    public List<Todo> findAll();
    
    public void remove(String id);
    
    public void removeAll();
    
}
