package org.springframework.samples.petclinic.service;


import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.*;
import org.springframework.samples.petclinic.util.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class PetsConverter extends AbstractConverter<Pet, MyPetsAndOwners> {
	
	 @Autowired
	 public PetsConverter(Mapper mapper) {
	  super(mapper, Pet.class, MyPetsAndOwners.class);
	 }
	
}
