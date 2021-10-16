package vn.com.codegym.cart.service.impl;

import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;
import vn.com.codegym.cart.entity.Product;
import vn.com.codegym.cart.repository.ProductRepository;
import vn.com.codegym.cart.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;


    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        List<Product> result = new ArrayList<>();
        while (productRepository.findAll().iterator().hasNext()) {
            result.add(productRepository.findAll().iterator().next());
        }
        return result;
    }
}
