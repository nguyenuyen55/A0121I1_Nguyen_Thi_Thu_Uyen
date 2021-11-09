package vn.com.codegym.exammodule4.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import vn.com.codegym.exammodule4.entity.Question;

public interface RepositoryQuestion extends CrudRepository<Question,Integer> {
    Page<Question> findAll(Pageable pageable);
    Page<Question> findAllByTitleContaining(Pageable pageable,String name);
}
