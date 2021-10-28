package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Contract;
import com.codegym.casestudy.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    Iterable<Contract> findAll();

//    Contract findById(String id);

    void save(Contract contract);

//    void delete(Contract contract);
}
