package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepositoryEmployee extends CrudRepository<Employee,Integer> {


    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findByEmployeeNameContaining(Optional<String> id, Pageable pageable);
}
