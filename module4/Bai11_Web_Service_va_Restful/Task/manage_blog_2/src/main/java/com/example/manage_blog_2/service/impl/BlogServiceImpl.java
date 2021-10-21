package com.example.manage_blog_2.service.impl;

import com.example.manage_blog_2.bean.Blog;
import com.example.manage_blog_2.repository.BlogRepository;
import com.example.manage_blog_2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> blogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findbyId(int id) {
        return blogRepository.findById(id).get();
    }
}
