package com.example.manage_blog_2.service;

import com.example.manage_blog_2.bean.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> blogs();
    Blog findbyId(int id);
}
