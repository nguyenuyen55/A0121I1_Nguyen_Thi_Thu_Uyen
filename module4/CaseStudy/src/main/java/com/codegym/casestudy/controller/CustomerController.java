package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.repository.RepositionCustomer;
import com.codegym.casestudy.repository.RepositionCustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    RepositionCustomerType repositionCustomerType;
    @Autowired
    RepositionCustomer repositionCustomer;

//    @PageableDefault(value = 4)
    @GetMapping("/listCustomer")
    public String getList(@RequestParam(name = "search", required = false) Optional<String> nameSearch, Model model, @PageableDefault(value = 4)  Pageable pageable) {
        if (nameSearch.isPresent()) {
            model.addAttribute("search",nameSearch.get());
            Page<Customer> customers = repositionCustomer.findByCustomerIdContaining(nameSearch, pageable);
            model.addAttribute("customers",customers);
        } else {
            model.addAttribute("customers", repositionCustomer.findAll(pageable));
        }
        return "customer/listCustomer";
    }

    @GetMapping("/createCustomer")
    public String showCreateCustomer(Model model) {
        model.addAttribute("customerTypes", repositionCustomerType.findAll());
        model.addAttribute("customer", new Customer());
        model.addAttribute("action", "create");
        return "customer/create";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@RequestParam(name = "action") String action, @Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", repositionCustomerType.findAll());
            model.addAttribute("action", "create");

            return "customer/create";
        }
        repositionCustomer.save(customer);
        if (action.equals("create")) {
            redirectAttributes.addFlashAttribute("mess", "Add Successful ^^");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Update Successful ><");
        }
        return "redirect:/listCustomer";
    }

    @GetMapping("/edit/{id}")
    public String showEditCustomer(@PathVariable(name = "id") String id, Model model) {
        model.addAttribute("customerTypes", repositionCustomerType.findAll());
        Customer customer = repositionCustomer.findById(id);
        model.addAttribute("typeId", customer.getCustomertypes().getCustomerTypeId());
//         customer.setBirthday(customer.getBirthday().getDay()+1);
//        customer.getBirthday().setDate(customer.getBirthday().getDay()+1);

        model.addAttribute("action", "edit");
        model.addAttribute("customer", customer);
        return "customer/create";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String showDeleteCustomer(@PathVariable(name = "id") String id, Model model) {
        Customer customer = repositionCustomer.findById(id);
        repositionCustomer.delete(customer);
        model.addAttribute("customers", repositionCustomer.findAll());
        return "redirect:/listCustomer";
    }
}
