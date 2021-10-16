package vn.com.codegym.cart.service;

import vn.com.codegym.cart.entity.Product;

import java.util.List;

public interface ProductService {
    Product findById(int id);

    List<Product> findAll();
}
