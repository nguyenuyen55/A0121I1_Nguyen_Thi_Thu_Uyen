package vn.com.codegym.manageblogajax.service;

import vn.com.codegym.manageblogajax.bean.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> blogs();
    Blog findbyId(int id);
    void save(Blog blog);
    void delete(int id);
    List<Blog> findByTitleContaining(String search);
    List<Blog> findTop1(int count);
}
