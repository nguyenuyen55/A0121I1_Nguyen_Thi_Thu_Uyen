package vn.com.codegym.exammodule4.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.codegym.exammodule4.entity.Question;
import vn.com.codegym.exammodule4.repository.RepositoryQuestion;
import vn.com.codegym.exammodule4.service.QuestionService;

import java.util.List;
@Service
public class QuestionImpl implements QuestionService {
    @Autowired
    RepositoryQuestion question;
    @Override
    public Page<Question> findAll(Pageable pageable) {
        return question.findAll(pageable);
    }



    @Override
    public Page<Question> findAllByTitleContaining(Pageable pageable,String name) {
        return  question.findAllByTitleContaining(pageable,name);
    }
}
