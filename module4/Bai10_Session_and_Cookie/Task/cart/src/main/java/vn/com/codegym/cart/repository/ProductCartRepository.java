package vn.com.codegym.cart.repository;

import org.springframework.data.repository.CrudRepository;
import vn.com.codegym.cart.entity.Product;
import vn.com.codegym.cart.entity.ProductCart;

public interface ProductCartRepository extends CrudRepository<ProductCart,Integer> {

}
