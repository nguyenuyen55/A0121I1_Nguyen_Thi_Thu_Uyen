package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("action", "update");

        return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = new Customer();
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("action", "create");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public ModelAndView showdelete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        customerService.delete(id);
        return modelAndView;
    }


    @PostMapping
    public String updateCustomer(Customer customer) {
        List<Customer> customers = customerService.findAll();
        int fag=0;
        for (Customer cus:
             customers) {
            if(customers.stream().anyMatch(c -> c.getId().equals(customer.getId()))){
                customerService.save(customer);
                fag++;
                break;
            }
        }
        if(fag==0){
            customerService.save1(customer);
        }

        return "redirect:/customers";
    }
}
