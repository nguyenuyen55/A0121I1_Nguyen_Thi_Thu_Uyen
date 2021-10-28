package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Contract;
import com.codegym.casestudy.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryContract extends JpaRepository<Contract,Integer> {
    Page<Contract> findAll(Pageable pageable);
}
