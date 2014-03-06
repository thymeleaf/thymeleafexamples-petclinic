package org.springframework.samples.petclinic.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Todo;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.service.TodoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleRestController {

	private final ClinicService clinicService;
	private final TodoService todoService;

    @Autowired
    public ExampleRestController(ClinicService clinicService, TodoService todoService) {
        this.clinicService = clinicService;
        this.todoService = todoService;
    }

	@RequestMapping(
			value = "/api/owner/{lastname}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Owner> getByLastName(@PathVariable("lastname") String lastName) {

        // find owners by last name
		Collection<Owner> results = this.clinicService.findOwnerByLastName(lastName);
        return results;
	}

	@RequestMapping(
			value = "/api/todo/all",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Todo> findAll() {
		List<Todo> results = todoService.findAll();
        return results;
	}
	
}
