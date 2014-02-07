package org.springframework.samples.petclinic.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.model.Todo;
import org.springframework.samples.petclinic.service.TodoService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {

	private final TodoService todoService;

    @Autowired
    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value="/api/todo", method = RequestMethod.GET, produces = "application/json") @ResponseBody
    public List<Todo> findAll() {
        return todoService.findAll();
    }
    
    @RequestMapping(value = "/api/todo/{id}",method = RequestMethod.GET ) @ResponseBody
    public final Todo get( @PathVariable( "id" ) final String id ){
        return this.todoService.findById(id);
    }

    @RequestMapping(value="/api/todo", method = RequestMethod.POST, consumes = "application/json", produces = "application/json") @ResponseStatus(HttpStatus.CREATED) @ResponseBody
    public Todo create(@RequestBody Todo todo) {
        Assert.notNull(todo);
        return todoService.create(todo);
    }

    @RequestMapping(value = "/api/todo/{id}", method = RequestMethod.PUT) @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Todo todo, @PathVariable String id) {
        Assert.isTrue(todo.getId().equals(id));
        todoService.update(todo);
    }

    @RequestMapping(value = "/api/todo/{id}", method = RequestMethod.DELETE) @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable String id) {
    	todoService.remove(id);
    }
	
}
