package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Position;
import org.springframework.data.repository.CrudRepository;

import javax.sql.rowset.CachedRowSet;

public interface RepositoryPosition extends CrudRepository<Position,Integer> {
}
