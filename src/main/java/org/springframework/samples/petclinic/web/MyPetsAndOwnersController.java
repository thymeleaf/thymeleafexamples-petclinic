package org.springframework.samples.petclinic.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.samples.petclinic.model.MyPetsAndOwners;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.service.OwnersConverter;
import org.springframework.samples.petclinic.service.PetsConverter;
import org.springframework.samples.petclinic.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyPetsAndOwnersController {

    private final ClinicService clinicService;
    
    private final PetsConverter petsConverter;
    
    private final OwnersConverter ownersConverter;

	
	@Autowired
	public MyPetsAndOwnersController(ClinicService clinicService, PetsConverter petsConverter, OwnersConverter ownersConverter){
		this.clinicService = clinicService;
		this.petsConverter = petsConverter;
		this.ownersConverter = ownersConverter;
	}
	
	
	@RequestMapping(value = "/PetsAndOwners", method = RequestMethod.GET)
	public String goIndex(Model model) {
				
		Collection<Pet> listPets = new ArrayList<Pet>();
		listPets = clinicService.allPet();
		
		Collection<Owner> listOwner = new ArrayList<Owner>();
		listOwner = clinicService.allOwner();
		
		Collection<MyPetsAndOwners> listPetsMyPetsAndOwners = new ArrayList<MyPetsAndOwners>();
		listPetsMyPetsAndOwners.addAll(petsConverter.convertMyBeanList(listPets));
		
		Collection<MyPetsAndOwners> listOwnersMyPetsAndOwners = new ArrayList<MyPetsAndOwners>();
		listOwnersMyPetsAndOwners.addAll(ownersConverter.convertMyBeanList(listOwner));
		
		Collection<MyPetsAndOwners> listAll = new ArrayList<MyPetsAndOwners>();
		
		for(MyPetsAndOwners owner : listOwnersMyPetsAndOwners){
			for(MyPetsAndOwners pet : listPetsMyPetsAndOwners){
				if(owner.getOwnerId().equals(pet.getOwnerId())){
					MyPetsAndOwners myPetOwner = new MyPetsAndOwners();
					myPetOwner.setOwnerFirstName(owner.getOwnerFirstName());
					myPetOwner.setOwnerId(owner.getOwnerId());
					myPetOwner.setPetName(pet.getPetName());
					listAll.add(myPetOwner);
				}
			}
		}
		
		
		model.addAttribute("list", listAll);
		return "PetsAndOwners";
	}

	
}
