package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
@PostMapping("/validation")
    public String validationForm(@Validated @ModelAttribute User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "index";
        }
        return "result";
    }
}
