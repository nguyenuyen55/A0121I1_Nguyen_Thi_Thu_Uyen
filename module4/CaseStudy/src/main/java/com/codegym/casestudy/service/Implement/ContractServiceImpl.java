package com.codegym.casestudy.service.Implement;

import com.codegym.casestudy.entity.Contract;
import com.codegym.casestudy.repository.RepositoryContract;
import com.codegym.casestudy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    RepositoryContract repositoryContract;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return repositoryContract.findAll(pageable);
    }

    @Override
    public Iterable<Contract> findAll() {
        return repositoryContract.findAll();
    }

    @Override
    public void save(Contract contract) {
        repositoryContract.save(contract);
    }
}
