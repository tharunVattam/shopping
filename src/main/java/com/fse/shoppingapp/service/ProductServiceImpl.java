package com.fse.shoppingapp.service;

import com.fse.shoppingapp.model.Product;
import com.fse.shoppingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByName(String name) throws Exception {
        Optional<Product> product = productRepository.findById(name);
        if(product.isPresent()){
            return product.get();
        }
        else{
            throw new Exception("No products found with provided name");
        }
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public String deleteProduct(String name) {
        productRepository.deleteById(name);
        return "Product successfully deleted";
    }

    @Override
    public Product updateProductStatus(String name, String status) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(name);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setStatus(status);
            return productRepository.save(product);
        }
        else{
            throw new Exception("No product found with provided name");
        }

    }

}
