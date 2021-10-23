package com.example.manage_customer1.repository;

import com.example.manage_customer1.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(Customer customer);

    void update(Customer customer);

    List<Customer> searchByFirstname(String kq);
}
