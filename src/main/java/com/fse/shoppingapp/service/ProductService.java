package com.fse.shoppingapp.service;

import com.fse.shoppingapp.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductByName(String name) throws Exception;

    public Product addProduct(Product product);

    public Product updateProductStatus(String name, String status) throws Exception;

    public String deleteProduct(String name);


}
