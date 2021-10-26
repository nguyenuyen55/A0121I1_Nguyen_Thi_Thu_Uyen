package com.example.managerblog.service;

import com.example.managerblog.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> listBogs();
    void SaveOrEdit(Blog blog);
    void delete(int id);
    Optional<Blog> view(int id);
    Page<Blog> findAll(Pageable pageable);
}
