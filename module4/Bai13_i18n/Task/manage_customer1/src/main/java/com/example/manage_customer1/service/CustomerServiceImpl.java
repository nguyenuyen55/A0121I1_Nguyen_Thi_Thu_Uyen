package com.example.manage_customer1.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.manage_customer1.model.Customer;
import com.example.manage_customer1.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {
        customerRepository.remove(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public List<Customer> searchByFirstname(String kq) {
        return customerRepository.searchByFirstname(kq);
    }
}
