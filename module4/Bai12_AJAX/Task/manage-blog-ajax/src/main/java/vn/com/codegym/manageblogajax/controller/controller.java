package vn.com.codegym.manageblogajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.codegym.manageblogajax.service.BlogService;

@Controller
public class controller {
    @Autowired
    BlogService blogService;
//    @GetMapping("/")
//    public String getList(Model model){
//        model.addAttribute("blogs",blogService.blogs());
//        return "blogs/index";
//    }
    @GetMapping("/search")
    public String getListSearch(@RequestParam(name = "search") String name,Model model ){
        model.addAttribute("blogs",blogService.findByTitleContaining(name));
        return "blogs/index";
    }
    @GetMapping("/")
    public String getListTop(Model model){
        model.addAttribute("blogs",blogService.findTop1(0));
        return "blogs/index";
    }
}
