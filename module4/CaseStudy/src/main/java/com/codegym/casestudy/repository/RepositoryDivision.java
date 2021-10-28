package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Division;
import com.codegym.casestudy.entity.Position;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryDivision extends CrudRepository<Division,Integer> {
}
