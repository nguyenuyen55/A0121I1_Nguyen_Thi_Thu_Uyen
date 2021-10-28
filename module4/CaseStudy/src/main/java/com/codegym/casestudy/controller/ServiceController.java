package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.entity.Service;
import com.codegym.casestudy.repository.RepositoryRentType;
import com.codegym.casestudy.repository.RepositoryServiceType;
import com.codegym.casestudy.service.Service_ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ServiceController {
    @Autowired
    Service_ServiceClass service_serviceClass;
    @Autowired
    RepositoryRentType repositoryRentType;
    @Autowired
    RepositoryServiceType repositoryServiceType;
    @GetMapping("/listService")
    public String getListService(Model model, Pageable pageable){
        model.addAttribute("services",service_serviceClass.findAll(pageable));
        return "/service/listService";
    }
    @GetMapping("/createService")
    public String formCreateService(Model model, Pageable pageable){
        model.addAttribute("service",new Service());
        model.addAttribute("rentTypes",repositoryRentType.findAll());
        model.addAttribute("serTypes",repositoryServiceType.findAll());
        return "/service/createService";
    }
    @PostMapping("/createService")
    public String createService(Model model, @ModelAttribute Service service, RedirectAttributes ra){
       service_serviceClass.save(service);
       ra.addFlashAttribute("mess","add successful");
       return "redirect:/listService";
    }
    @GetMapping("/deleteService/{id}")
    public String showDeleteCustomer(@PathVariable(name = "id") String id) {
        Service service = service_serviceClass.findById(id);
        service_serviceClass.delete(service);
        return "redirect:/listService";
    }

}
