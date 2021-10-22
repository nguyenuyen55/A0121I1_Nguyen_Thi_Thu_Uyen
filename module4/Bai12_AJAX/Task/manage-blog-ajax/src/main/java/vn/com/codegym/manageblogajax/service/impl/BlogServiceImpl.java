package vn.com.codegym.manageblogajax.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.codegym.manageblogajax.bean.Blog;
import vn.com.codegym.manageblogajax.repository.BlogRepository;
import vn.com.codegym.manageblogajax.service.BlogService;

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

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByTitleContaining(String search) {
        return blogRepository.findByTitleContaining(search);
    }

    @Override
    public List<Blog> findTop1(int count) {
        return blogRepository.findTop1(count);
    }
}
