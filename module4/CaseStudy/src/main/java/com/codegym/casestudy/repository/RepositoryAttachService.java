package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.ContractDetail;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryAttachService extends CrudRepository<ContractDetail,Integer> {
}
