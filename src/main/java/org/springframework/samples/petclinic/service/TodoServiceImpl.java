package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Todo;
import org.springframework.samples.petclinic.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	@Override
	public Todo findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo create(Todo todo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Todo todo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

}
