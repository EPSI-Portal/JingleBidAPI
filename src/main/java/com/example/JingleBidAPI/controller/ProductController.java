package com.example.JingleBidAPI.controller;

import com.example.JingleBidAPI.model.Product;
import com.example.JingleBidAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/product")
    public void postProduct(@RequestBody Product product) throws InterruptedException, ExecutionException {
            Product product1 = new Product();
            product1.setId(product.getId());
            product1.setName(product1.getName());
            productRepository.save(product);
    }

    @GetMapping(path = "/product")
    public Iterable<Product> getProduct() throws InterruptedException, ExecutionException {
        return productRepository.findAll();
    }

    @GetMapping(path = "/product/{id}")
    public Product getProductDetails(@RequestParam String id) throws InterruptedException, ExecutionException {
        return productRepository.findById(Integer.valueOf(id)).get();
    }

    @PutMapping(path = "/product")
    public void updateProduct(@RequestBody Product product, String id ) throws InterruptedException, ExecutionException {
        Product product1 = productRepository.findById(Integer.valueOf(id)).get();
        product1.setName(product.getName());
    }

    @DeleteMapping(path = "/product")
    public void deleteProduct(@RequestParam String id) throws InterruptedException, ExecutionException {
        productRepository.deleteById(Integer.valueOf(id));
    }

}
