package org.springframework.samples.petclinic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String goIndex() {
		return "index";
	}

}
