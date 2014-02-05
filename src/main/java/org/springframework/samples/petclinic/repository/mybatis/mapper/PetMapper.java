package org.springframework.samples.petclinic.repository.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;

public interface PetMapper {

    public List<PetType> findPetTypes();

    public Pet findById(@Param("id") int id);

    public void save(Pet pet);

}