package vn.com.codegym.exammodule4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.com.codegym.exammodule4.entity.Question;

import java.util.List;

public interface QuestionService {
    Page<Question> findAll(Pageable pageable);

    Page<Question> findAllByTitleContaining(Pageable pageable,String name);

}
