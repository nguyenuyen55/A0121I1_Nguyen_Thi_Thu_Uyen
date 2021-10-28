package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.AttachService;
import com.codegym.casestudy.entity.Contract;
import com.codegym.casestudy.entity.ContractDetail;
import com.codegym.casestudy.repository.RepositoryAttachService;
import com.codegym.casestudy.repository.RepositoryContractDetail;
import com.codegym.casestudy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContractDetailController {
    @Autowired
    ContractService contractService;
    @Autowired
    RepositoryAttachService repositoryAttachService;
    @Autowired
    RepositoryContractDetail contractDetail;
    @GetMapping("/listContractDetail")
    public String getlist(Model model, @PageableDefault(5) Pageable pageable){
        model.addAttribute("contractDetails",contractDetail.findAll(pageable));
        if(pageable.getPageNumber()==0) {
            model.addAttribute("countPage", 0);
        }else {
            model.addAttribute("countPage", 5);
        }
            return "contractDetail/listContractDetail";

    }
    @GetMapping("/createContractDetail")
    public String formcreate(Model model){
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("anh",repositoryAttachService.findAll());
        return "contractDetail/createContractDetail";
    }
    @PostMapping("/createContractDetail")
    public String creatContract(@ModelAttribute ContractDetail contract, RedirectAttributes redirectAttributes){
        contractDetail.save(contract);
        redirectAttributes.addFlashAttribute("message","Save successful");
        return "redirect:/listContractDetail";
    }
}
