package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.CustomerType;
import org.springframework.data.repository.CrudRepository;

public interface RepositionCustomerType extends CrudRepository<CustomerType,Integer> {
}
