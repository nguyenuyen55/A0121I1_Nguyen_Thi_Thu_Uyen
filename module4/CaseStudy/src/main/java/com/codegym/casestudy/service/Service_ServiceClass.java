package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface Service_ServiceClass {
    Page<Service> findAll(Pageable pageable);

    Iterable<Service> findAll();

    Service findById(String id);

    void save(Service service);

    void delete(Service service);

}
