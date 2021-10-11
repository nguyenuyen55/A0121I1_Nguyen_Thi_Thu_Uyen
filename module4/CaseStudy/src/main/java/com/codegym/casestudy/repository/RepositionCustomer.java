package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.entity.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RepositionCustomer extends CrudRepository<Customer,Integer> {
    Page<Customer> findAll(Pageable pageable);
    @Query(value = "select * from customer where customer_id= :id",nativeQuery = true)
    Customer findById(@Param("id") String id);
//    @Query(value = "select * from customer where customer_id like ?1%",nativeQuery = true)
    Page<Customer> findByCustomerIdContaining( Optional<String> id, Pageable pageable);

}
