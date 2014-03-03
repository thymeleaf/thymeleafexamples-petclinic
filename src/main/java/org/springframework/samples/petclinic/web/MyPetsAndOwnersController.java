package org.springframework.samples.petclinic.web;

import java.util.ArrayList;
import java.util.Collection;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.MyPetsAndOwners;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.util.AbstractConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyPetsAndOwnersController {

    private final ClinicService clinicService;
    
    private final Mapper mapper;
	
	@Autowired
	public MyPetsAndOwnersController(ClinicService clinicService, org.dozer.Mapper mapper){
		this.clinicService = clinicService;
		this.mapper = mapper;
	}
	
	
	@RequestMapping(value = "/PetsAndOwners", method = RequestMethod.GET)
	public String goIndex(Model model) {
				
		Collection<Pet> listPets = new ArrayList<Pet>();
		listPets = clinicService.allPet();
		
		Collection<Owner> listOwner = new ArrayList<Owner>();
		listOwner = clinicService.allOwner();

		Collection<MyPetsAndOwners> listPetsMyPetsAndOwners = new ArrayList<MyPetsAndOwners>();

		listPetsMyPetsAndOwners.addAll(AbstractConverter.map(mapper, listPets, MyPetsAndOwners.class));
//		listPetsMyPetsAndOwners.clear();

		Collection<MyPetsAndOwners> listOwnersMyPetsAndOwners = new ArrayList<MyPetsAndOwners>();
		
		listPetsMyPetsAndOwners.addAll(AbstractConverter.map(mapper, listOwner, MyPetsAndOwners.class));
//		listOwnersMyPetsAndOwners.clear();
		
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
