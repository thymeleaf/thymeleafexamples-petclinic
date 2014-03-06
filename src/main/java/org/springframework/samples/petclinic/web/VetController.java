/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.MyVets;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.service.VetsConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
public class VetController {

    private final ClinicService clinicService;

    private final VetsConverter vetsConverter;

    @Autowired
    public VetController(ClinicService clinicService, VetsConverter vetsConverter) {
        this.clinicService = clinicService;
        this.vetsConverter = vetsConverter;
    }

    @RequestMapping("/vets")
    public String showVetList(Model model) {
        // Here we are returning an object of type 'Vets' rather than a collection of Vet objects 
        // so it is simpler for Object-Xml mapping
        Vets vets = new Vets();
        MyVets myVets = (MyVets)vetsConverter.convertMyBean(vets);
        Collection<Vet> findVets = this.clinicService.findVets();
        
        myVets.getVets().addAll(findVets);
        model.addAttribute("vets", myVets);
//        vets.getVetList().addAll(findVets);
//        model.addAttribute("vets", vets);
        return "vets/vetList";
    }


}
