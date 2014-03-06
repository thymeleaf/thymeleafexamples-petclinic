package org.springframework.samples.petclinic.model;

import java.util.ArrayList;
import java.util.List;




public class MyVets extends Person{
	
    private List<Vet> vets;


	public void setVets(List<Vet> vets) {
		this.vets = vets;
	}

	public List<Vet> getVets() {
		if (vets == null) {
            vets = new ArrayList<Vet>();
        }
        return vets;
	}



}
