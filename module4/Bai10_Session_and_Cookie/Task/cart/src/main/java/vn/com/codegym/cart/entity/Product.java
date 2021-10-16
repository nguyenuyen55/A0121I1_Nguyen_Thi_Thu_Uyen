package vn.com.codegym.cart.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    private String code;
    private String nameProduct;
    private double oldPrice;
    private double newPrice;
    private String imgProduct;
    private String description;
    @OneToOne(targetEntity = ProductCart.class,fetch = FetchType.EAGER)
   private ProductCart productCart;
    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCode() {
        return code;
    }

    public ProductCart getProductCart() {
        return productCart;
    }

    public void setProductCart(ProductCart productCart) {
        this.productCart = productCart;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Product() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
