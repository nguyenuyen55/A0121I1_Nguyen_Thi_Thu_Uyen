package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryService extends CrudRepository<Service,String> {
    Page<Service> findAll(Pageable pageable);

}
