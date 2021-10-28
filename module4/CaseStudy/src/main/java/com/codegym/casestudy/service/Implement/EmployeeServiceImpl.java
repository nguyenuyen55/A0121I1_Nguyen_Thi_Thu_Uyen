package com.codegym.casestudy.service.Implement;

import com.codegym.casestudy.entity.Employee;
import com.codegym.casestudy.repository.RepositoryEmployee;
import com.codegym.casestudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    RepositoryEmployee repositoryEmployee;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return repositoryEmployee.findAll(pageable);
    }

    @Override
    public Iterable<Employee> findAll() {
        return repositoryEmployee.findAll();
    }

    @Override
    public Employee findById(int id) {
        return repositoryEmployee.findById(id).get();
    }

    @Override
    public void save(Employee employee) {
        repositoryEmployee.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        repositoryEmployee.delete(employee);
    }

    @Override
    public Page<Employee> findByEmployeeNameContaining(Optional<String> id, Pageable pageable) {
        return repositoryEmployee.findByEmployeeNameContaining(id,pageable);
    }

}
