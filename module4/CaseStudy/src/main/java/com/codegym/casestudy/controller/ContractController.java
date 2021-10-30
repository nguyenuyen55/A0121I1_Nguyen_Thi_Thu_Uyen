package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.Contract;
import com.codegym.casestudy.repository.RepositionCustomer;
import com.codegym.casestudy.service.ContractService;
import com.codegym.casestudy.service.EmployeeService;
import com.codegym.casestudy.service.Service_ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    Service_ServiceClass service_serviceClass;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    RepositionCustomer conRepositionCustomer;
    @GetMapping("/listContract")
    public String getlist(Model model,@PageableDefault(5) Pageable pageable){
        model.addAttribute("contracts",contractService.findAll(pageable));
        return "contract/listContract";
    }
    @GetMapping("/createContract")
    public String formcreate(Model model){
        model.addAttribute("contract",new Contract());
        model.addAttribute("customers",conRepositionCustomer.findAll());
        model.addAttribute("employees",employeeService.findAll());
        model.addAttribute("services",service_serviceClass.findAll());
        return "contract/createContract";
    }
    @PostMapping("/createContract")
    public String creatContract(@Validated @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
       new Contract().validate(contract,bindingResult);
       if(bindingResult.hasErrors()){
//           model.addAttribute("contract",new Contract());
           model.addAttribute("customers",conRepositionCustomer.findAll());
           model.addAttribute("employees",employeeService.findAll());
           model.addAttribute("services",service_serviceClass.findAll());
           return "contract/createContract";
       }

        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message","Save successful");
        return "redirect:/listContract";
    }

}
