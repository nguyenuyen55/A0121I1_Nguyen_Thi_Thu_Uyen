package vn.com.codegym.cart.repository;

import org.springframework.data.repository.CrudRepository;
import vn.com.codegym.cart.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {

}
