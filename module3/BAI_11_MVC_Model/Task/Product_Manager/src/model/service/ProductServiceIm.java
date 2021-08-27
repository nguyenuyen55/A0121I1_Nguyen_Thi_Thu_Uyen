package model.service;

import model.bean.Product;
import model.repository.ProductRepository;
import model.repository.ProductRepositoryImp;

import java.util.List;

public class ProductServiceIm implements ProductService {

    ProductRepository repository = new ProductRepositoryImp();
    @Override
    public Product findId(String idproduct) {
        return repository.findId(idproduct);
    }

    @Override
    public List<Product> listAll() {
        return repository.listAll();
    }

    @Override
    public void add(Product product) {
repository.add(product);
    }

    @Override
    public void update(Product product, String id) {
repository.update(product,id);
    }

    @Override
    public void delete(String id) {
repository.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return repository.search(name);
    }
}
