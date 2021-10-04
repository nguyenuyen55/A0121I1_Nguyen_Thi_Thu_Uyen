package codegym.repository;

import codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer,Integer> {
Page<Customer> findAllByFirstName(String firstname,Pageable pageable);
    Page<Customer> findAll(Pageable pageable);
}
