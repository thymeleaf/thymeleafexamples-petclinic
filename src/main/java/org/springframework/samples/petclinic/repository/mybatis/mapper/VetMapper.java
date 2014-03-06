package org.springframework.samples.petclinic.repository.mybatis.mapper;

import java.util.Collection;

import org.springframework.samples.petclinic.model.Vet;

public interface VetMapper {

    public Collection<Vet> findAll();

}