package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.entity.Employee;
import com.codegym.casestudy.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Iterable<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void delete(Employee employee);
    Page<Employee> findByEmployeeNameContaining(Optional<String> id, Pageable pageable);
}
