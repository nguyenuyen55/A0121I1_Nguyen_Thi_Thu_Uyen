package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Contract;
import com.codegym.casestudy.entity.ContractDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryContractDetail extends CrudRepository<ContractDetail,Integer> {
    Object findAll(Pageable pageable);
}
