package org.springframework.samples.petclinic.repository.mybatis.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;
import org.springframework.samples.petclinic.model.Owner;

public interface OwnerMapper {

    public Collection<Owner> findByLastName(@Param("lastName") String lastName);

    public Owner findById(@Param("id") int id);

    public void save(Owner owner);

}