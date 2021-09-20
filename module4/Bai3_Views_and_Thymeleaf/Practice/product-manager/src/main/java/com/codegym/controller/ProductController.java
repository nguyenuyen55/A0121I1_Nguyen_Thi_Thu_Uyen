package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceIm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productServiceEmp = new ProductServiceIm();

    @GetMapping("/")
    public String index(Model model) {

        List<Product> products = productServiceEmp.listAll();
        model.addAttribute("products", products);
        return "/products/list";
    }
}