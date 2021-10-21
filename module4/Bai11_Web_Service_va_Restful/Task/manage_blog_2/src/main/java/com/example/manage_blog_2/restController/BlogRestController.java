package com.example.manage_blog_2.restController;


import com.example.manage_blog_2.bean.Blog;
import com.example.manage_blog_2.repository.BlogRepository;
import com.example.manage_blog_2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    private BlogService blogService;
    @GetMapping(value = {"/", "/blog"})
    public ResponseEntity<List<Blog>> showList(){
        List<Blog> blogList = blogService.blogs();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> delete(@PathVariable int id){
        Blog blog = blogService.findbyId(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }



}
