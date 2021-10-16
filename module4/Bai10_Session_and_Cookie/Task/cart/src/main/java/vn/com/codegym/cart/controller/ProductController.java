package vn.com.codegym.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.com.codegym.cart.entity.Cart;
import vn.com.codegym.cart.entity.Product;
import vn.com.codegym.cart.entity.ProductCart;
import vn.com.codegym.cart.repository.ProductCartRepository;
import vn.com.codegym.cart.repository.ProductRepository;
import vn.com.codegym.cart.service.ProductService;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("carts")

public class ProductController {
    @ModelAttribute("carts")
    public HashMap<Integer,Cart> setCard(){
        return new HashMap<>();
    }

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCartRepository cartRepository;
    @GetMapping("/")
    public String getList(Model model){

        model.addAttribute("products",productRepository.findAll());
        return "product/listProduct";
    }
    @GetMapping("/view/{id}")
    public String getProduct(@PathVariable("id") int id, Model model, @SessionAttribute("carts")HashMap<Integer,Cart> carts){
        model.addAttribute("product",productRepository.findById(id).get());
        return "product/viewProduct";
    }
    @GetMapping("/buy")
    public String buyCart(Model model,@SessionAttribute("carts")HashMap<Integer,Cart> carts){
        model.addAttribute("carts",carts);
        model.addAttribute("total",totalMoney(carts));
        if(totalMoney(carts)==0){
            model.addAttribute("display","Yet option product ??");

        }
        return "product/cart";
    }
    @GetMapping("/buy/{id}")
    public String getProduct1(@PathVariable("id") int id, Model model, @SessionAttribute("carts")HashMap<Integer,Cart> carts, RedirectAttributes ra){
//       model.addAttribute("product",productRepository.findById(id).get());
        Product product = productRepository.findById(id).get();
        if(product!=null){
            Cart cart;
            if(carts.containsKey(product.getIdProduct())){
                cart= carts.get(product.getIdProduct());
                cart.setCount(cart.getCount()+1);
                carts.put(product.getIdProduct(),cart);
            }else {
                cart=new Cart();
                cart.setCount(1);
                cart.setProduct(product);
                carts.put(product.getIdProduct(),cart);
            }
        }
        int ca=carts.size();

        ra.addFlashAttribute("quantity",carts.size());

        return "redirect:/";
    }
    public double totalMoney(HashMap<Integer,Cart> carts){
        double result=0;
//        HashMap<Integer,Cart> cart;

        for (Map.Entry<Integer,Cart> cart : carts.entrySet()) {
           result+=(cart.getValue().getProduct().getNewPrice()*cart.getValue().getCount());
        }
        return result;
    }
    @GetMapping("/back")
    public String back(@SessionAttribute("carts")HashMap<Integer,Cart> carts,RedirectAttributes ra){
//        model.addAttribute("carts",carts);
        ra.addFlashAttribute("quantity",carts.size());
        return "redirect:/";
    }
    @GetMapping("/pay")
    public String pay(@SessionAttribute("carts")HashMap<Integer,Cart> carts,RedirectAttributes ra){
//        model.addAttribute("carts",carts);
        ProductCart productCart=new ProductCart();
        String ma=createRandomWord(4);
        List<Product> productList=new ArrayList<>();
        for (Map.Entry<Integer,Cart> cart : carts.entrySet()) {
            productCart.setCodeCart(ma);
            productCart.setCount(cart.getValue().getCount());
            productCart.setProduct(cart.getValue().getProduct());
            cartRepository.save(productCart);
            productCart= new ProductCart();
        }
        carts.clear();
        ra.addFlashAttribute("quantity",carts.size());
        ra.addFlashAttribute("message","pay successful");
        return "redirect:/";
    }
    //sinh ra ma cart
    public static String createRandomWord(int len) {
        String name = "";
        for (int i = 0; i < len; i++) {
            int v = 1 + (int) (Math.random() * 26);
            char c = (char) (v + (i == 0 ? 'A' : 'a') - 1);
            name += c;
        }
        return name;
    }
}
