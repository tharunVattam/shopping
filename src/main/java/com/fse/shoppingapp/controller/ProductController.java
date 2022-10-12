package com.fse.shoppingapp.controller;


import com.fse.shoppingapp.model.Product;
import com.fse.shoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) throws Exception{
        return new ResponseEntity<>(productService.getProductByName(name),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product),HttpStatus.OK);
    }

    @PostMapping("/update/{name}")
    public ResponseEntity<Product> updateProductStatus(@RequestBody String status,@PathVariable String name) throws Exception{
        return new ResponseEntity<>(productService.updateProductStatus(name,status),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteProduct(@PathVariable String name){
        return new ResponseEntity<>(productService.deleteProduct(name),HttpStatus.OK);
    }
}
