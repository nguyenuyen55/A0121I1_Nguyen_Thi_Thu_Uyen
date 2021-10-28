package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.RentType;
import com.codegym.casestudy.entity.ServiceType;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryServiceType extends CrudRepository<ServiceType,Integer> {
}
