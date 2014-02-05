package org.springframework.samples.petclinic.repository.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.samples.petclinic.model.Visit;

public interface VisitMapper {

    public List<Visit> findByPetId(@Param("id") int id);

    public void save(Visit visit);

}