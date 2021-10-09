package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.repository.RepositionCustomer;
import com.codegym.casestudy.repository.RepositionCustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    RepositionCustomerType repositionCustomerType;
    @Autowired
    RepositionCustomer repositionCustomer;
    @GetMapping("/listCustomer")
    public String getList(Model model){
        model.addAttribute("customers",repositionCustomer.findAll());
return "customer/listCustomer";
    }
    @GetMapping("/createCustomer")
    public String showCreateCustomer(Model model) {
        model.addAttribute("customerTypes",repositionCustomerType.findAll());
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }
    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer,Model model) {
        repositionCustomer.save(customer);
        model.addAttribute("customerTypes",repositionCustomerType.findAll());
        model.addAttribute("customer",new Customer());
        model.addAttribute("message", "Add Successful ^^");
        return "customer/create";
    }
}
