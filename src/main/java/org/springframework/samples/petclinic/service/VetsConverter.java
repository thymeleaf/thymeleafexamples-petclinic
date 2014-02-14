/**
 * 
 */
package org.springframework.samples.petclinic.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.MyVets;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.util.AbstractConverter;
import org.springframework.stereotype.Component;


@Component
public class VetsConverter extends AbstractConverter<Vets, MyVets>{
	
	
	 @Autowired
	 public VetsConverter(Mapper mapper) {
	  super(mapper, Vets.class, MyVets.class);
	 }

}
