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
package org.springframework.samples.petclinic.repository.mybatis;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.mybatis.mapper.OwnerMapper;
import org.springframework.stereotype.Repository;

/**
 * Using mybatis mapper
 *
 * @author Jose Juan Montiel
 */
@Repository
public class MyBatisOwnerRepositoryImpl implements OwnerRepository {

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Owner> findByLastName(String lastName) {
    	return ownerMapper.findByLastName(lastName+"%");
    }

    @Override
    public Owner findById(int id) {
    	return ownerMapper.findById(id);
    }


    @Override
    public void save(Owner owner) {
    	ownerMapper.save(owner);
    }

	@Override
	public Collection<Owner> all() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
