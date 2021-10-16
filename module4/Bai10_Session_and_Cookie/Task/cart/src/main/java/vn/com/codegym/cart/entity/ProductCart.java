package vn.com.codegym.cart.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCart;
    private String codeCart;
    private int count;
    @OneToOne(fetch = FetchType.LAZY)
    private Product product;

    public String getCodeCart() {
        return codeCart;
    }

    public void setCodeCart(String codeCart) {
        this.codeCart = codeCart;
    }

    public ProductCart() {
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
