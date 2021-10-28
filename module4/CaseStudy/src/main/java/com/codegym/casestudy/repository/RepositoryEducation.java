package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Education;
import com.codegym.casestudy.entity.Position;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryEducation extends CrudRepository<Education,Integer> {
}
