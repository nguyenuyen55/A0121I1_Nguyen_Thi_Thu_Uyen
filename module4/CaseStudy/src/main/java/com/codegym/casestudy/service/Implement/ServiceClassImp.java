package com.codegym.casestudy.service.Implement;

import com.codegym.casestudy.entity.Contract;
import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.entity.Service;
import com.codegym.casestudy.repository.RepositoryContract;
import com.codegym.casestudy.repository.RepositoryService;
import com.codegym.casestudy.service.Service_ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


@org.springframework.stereotype.Service
public class ServiceClassImp implements Service_ServiceClass {
    @Autowired
    RepositoryService repositoryService;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return repositoryService.findAll(pageable);
    }

    @Override
    public Iterable<Service> findAll() {
        return repositoryService.findAll();
    }

    @Override
    public Service findById(String id) {
        return repositoryService.findById(id).get();
    }

    @Override
    public void save(Service service) {
         repositoryService.save(service);
    }

    @Override
    public void delete(Service service) {
repositoryService.delete(service);
    }

}
