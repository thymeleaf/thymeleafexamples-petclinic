package org.springframework.samples.petclinic.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.MyPetsAndOwners;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.util.AbstractConverter;
import org.springframework.stereotype.Component;


@Component
public class OwnersConverter extends AbstractConverter<Owner, MyPetsAndOwners>{

	@Autowired
	public OwnersConverter(Mapper mapper) {
		super(mapper, Owner.class, MyPetsAndOwners.class);
	}
	
}
