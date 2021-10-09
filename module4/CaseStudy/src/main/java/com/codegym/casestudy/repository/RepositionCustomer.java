package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.entity.CustomerType;
import org.springframework.data.repository.CrudRepository;

public interface RepositionCustomer extends CrudRepository<Customer,Integer> {
}
