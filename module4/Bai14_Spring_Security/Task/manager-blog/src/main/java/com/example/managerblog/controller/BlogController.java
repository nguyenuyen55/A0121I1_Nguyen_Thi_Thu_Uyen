package com.example.managerblog.controller;

import com.example.managerblog.bean.Blog;
import com.example.managerblog.bean.Category;
import com.example.managerblog.repository.BlogRepository;
import com.example.managerblog.repository.CategoryRepository;
import com.example.managerblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping("/index")
    public String getList(@RequestParam("search") Optional<String> s,@RequestParam("cate") Optional<Integer> cate,Model model, @PageableDefault(value = 1) Pageable pageable  ) {
     if(s.isPresent()) {
         Page<Blog> blogs = blogRepository.findAllByTitleContaining(s.get(), pageable);
         model.addAttribute("cates",categoryRepository.findAll());
         model.addAttribute("blogs", blogs);
     }else if(cate.isPresent()) {
         Page<Blog> blogs = blogRepository.findAllByCategory( pageable,cate.get());
         model.addAttribute("cates",categoryRepository.findAll());
         model.addAttribute("blogs", blogs);
     }
     else{
        Page<Blog> blogs = blogService.findAll(pageable);
         model.addAttribute("cates",categoryRepository.findAll());
        model.addAttribute("blogs", blogs);}
        return "views/index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("action", "create");
        model.addAttribute("cates",categoryRepository.findAll());
        return "views/create";
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute Blog blog) {
        blogRepository.save(blog);
        model.addAttribute("action", "add Successful");
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable(name = "id") int id, Model model) {
        Optional<Blog> blog = blogRepository.findById(id);
        model.addAttribute("blog", blog.get());
        model.addAttribute("cates",categoryRepository.findAll());
        model.addAttribute("action", "edit");
        return "views/create";
    }

    @GetMapping("/delete/{id}")
    public String detele(@PathVariable(name = "id") int id, Model model) {
        blogService.delete(id);
        return "redirect:/index";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable(name = "id") int id, Model model) {
        Optional<Blog> blog =  blogRepository.findById(id);
        model.addAttribute("blog",blog.get());
        return "views/view";
    }

    @GetMapping("/category")
    public String getListCategory(Model model) {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "views/category/index";
    }
    @GetMapping("/category/create")
    public String showCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "views/category/create";
    }
    @PostMapping("/category/create")
    public String createCategory( @ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryRepository.save(category);
        redirectAttributes.addFlashAttribute("add","add successful");
        return "redirect:/category";
    }
    @GetMapping("category/edit/{id}")
    public String showEditCategory(@PathVariable(name = "id") int id, Model model) {
        Optional<Category> category = categoryRepository.findById(id);
        model.addAttribute("category", category.get());
        model.addAttribute("action", "edit");
        return "views/category/create";
    }
    @GetMapping("category/delete/{id}")
    public String deteleCategory(@PathVariable(name = "id") int id) {
        categoryRepository.deleteById(id);
        return "redirect:/category";
    }


}
