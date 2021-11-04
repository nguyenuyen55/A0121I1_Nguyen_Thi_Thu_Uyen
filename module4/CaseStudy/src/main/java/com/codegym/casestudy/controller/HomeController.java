package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.User;
import com.codegym.casestudy.repository.RepositoryUser_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;

@Controller
@SessionAttributes("username")
public class HomeController {
    @ModelAttribute("username")
    public String setusername(){
        return null;
    }
@Autowired
    RepositoryUser_Role repositoryUser_role;
@GetMapping("/login")
public String login(Model model){
//    model.addAttribute("user",new User());
    return "home/login";
}
    @GetMapping("/homeNe")
    public String home(Model model){
        return "home/home";
    }
//    @PostMapping("/login")
//    public String postlogin(@ModelAttribute User user , Model redirectAttributes, @SessionAttribute("username") String username){
////        redirectAttributes.addFlashAttribute("message","Thành công em yêu");
//        int dem=0;
//        for (User user1: repositoryUser_role.findAll()) {
//            if((user.getUsername().equals(user1.getUsername())) && (user.getPassword().equals(user1.getPassword()))){
//                username=user.getUsername();
//                dem++;
//            }
//        }
//
////        for (User user1: repositoryUser_role.findAll()) {
////            if(user.getPassword()==user1.getPassword() && dem==1){
////                dem++;
////            }
////        }
////        if(dem==2){
////            redirectAttributes.addAttribute("message","Thành công em yêu");
////        }
//        if(dem==1){
//            redirectAttributes.addAttribute("message","Đăng nhập thành công");
//        }else {
//            redirectAttributes.addAttribute("messagena","Tên đăng nhập sai hoặc mật khẩu bị sai");
//            return "home/login";
//        }
//        return "redirect:/listCustomer";
//    }
}
