package org.springframework.samples.petclinic.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Todo;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component(value = "todoRestClient")
public class TodoClient {

	private RestTemplate restTemplate;
	
	@Autowired
	public TodoClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;

	}

	private final static String todoServiceUrl = "http://localhost:8080/petclinic/api/todo";

	public Todo find_one() {
		ResponseEntity<Todo> todos = null;
		try {
			todos = (ResponseEntity) this.restTemplate.getForEntity(new URI(todoServiceUrl+"/1"), Todo.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return todos.getBody();
	}

	public List<Todo> findAll_basic() {
		ResponseEntity<Todo> todos = null;
		try {
			todos = (ResponseEntity) this.restTemplate.getForEntity(new URI(todoServiceUrl), ArrayList.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Todo> findAll_3_2() {
		List<Todo> todos = null;
		try {
			ParameterizedTypeReference<List<Todo>> typeRef = new ParameterizedTypeReference<List<Todo>>() {};
			ResponseEntity<List<Todo>> response = restTemplate.exchange(todoServiceUrl, HttpMethod.GET, null, typeRef);
			todos = response.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return todos;
	}
	
	public static void main(final String[] args) {
		final ApplicationContext appContext = new ClassPathXmlApplicationContext("client.xml");
		final TodoClient restClient = (TodoClient)appContext.getBean("todoRestClient");
		
		final Todo todoOne = restClient.find_one();
		final List<Todo> todosBasic = restClient.findAll_basic();
		
		final List<Todo> todos = restClient.findAll_3_2();
		for (Iterator iterator = todos.iterator(); iterator.hasNext();) {
			Todo todo = (Todo) iterator.next();
			System.out.println(todo.getId()+"-"+todo.getContent());	
		}
		
	}

}
