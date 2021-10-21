package com.example.manage_customer_use_restful.service;

import com.example.manage_customer_use_restful.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
