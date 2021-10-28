package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.entity.Employee;
import com.codegym.casestudy.repository.RepositoryDivision;
import com.codegym.casestudy.repository.RepositoryEducation;
import com.codegym.casestudy.repository.RepositoryPosition;
import com.codegym.casestudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    RepositoryDivision repositoryDivision;
    @Autowired
    RepositoryPosition repositoryPosition;
    @Autowired
    RepositoryEducation repositoryEducation;

    @GetMapping("/listEmployee")
    public String getListEmployee(Model model, @PageableDefault(value = 5) Pageable pageable, @RequestParam(value = "search",required = false) Optional<String> search){
        if(search.isPresent()){
            model.addAttribute("search",search.get());
            Page<Employee> employees = employeeService.findByEmployeeNameContaining(search, pageable);
            model.addAttribute("employees",employeeService.findByEmployeeNameContaining(search,pageable));

        }else {
            model.addAttribute("employees",employeeService.findAll(pageable));

        }
        return "employee/listEmployee";
    }
    @GetMapping("/createEmployee")
    public String formCreateEmployee(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("positions",repositoryPosition.findAll());
        model.addAttribute("educations",repositoryEducation.findAll());
        model.addAttribute("divisions",repositoryDivision.findAll());
        model.addAttribute("action","Create");
        return "employee/create";
    }
    @PostMapping("/createEmployee")
    public String createEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message","Save successful");
        return "redirect:/listEmployee";
    }
    @GetMapping("/editEmployee/{id}")
    public String formEditployee(@PathVariable("id") int id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        model.addAttribute("positionid",employee.getPositions().getPosition_id());
        model.addAttribute("educationid",employee.getEducations().getEducation_degree_id());
        model.addAttribute("divisionid",employee.getDivisions().getDivision_id());
        model.addAttribute("positions",repositoryPosition.findAll());
        model.addAttribute("educations",repositoryEducation.findAll());
        model.addAttribute("divisions",repositoryDivision.findAll());
        model.addAttribute("action","Update");
        return "employee/create";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.findById(id);
      employeeService.delete(employee);
        return "redirect:/listEmployee";
    }
    @GetMapping("/viewEmployee/{id}")
    public String formViewEmployee(@PathVariable("id") int id,Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        model.addAttribute("positions",repositoryPosition.findAll());
        model.addAttribute("educations",repositoryEducation.findAll());
        model.addAttribute("divisions",repositoryDivision.findAll());
        model.addAttribute("action","Create");
        return "employee/view";
    }

}
