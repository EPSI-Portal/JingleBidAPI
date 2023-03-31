package com.example.JingleBidAPI.controller;

import com.example.JingleBidAPI.model.Product;
import com.example.JingleBidAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping(path = "/product")
    public void postProduct(@RequestBody Product produt) throws InterruptedException, ExecutionException {
        Product product1 = new Product();
        product1.setName(produt.getName());
        productRepository.save(product1);
    }

    @GetMapping(path = "/product")
    public Iterable<Product> getProduct() throws InterruptedException, ExecutionException {
        return productRepository.findAll();
    }

    @GetMapping(path = "/product/{id}")
    public Product getProductDetails(@RequestParam Long id) throws InterruptedException, ExecutionException {
        return productRepository.findById(id).get();
    }

    @PutMapping(path = "/product")
    public void updateProduct(@RequestBody Product product, Long id ) throws InterruptedException, ExecutionException {
        Product product1 = productRepository.findById(id).get();
        product1.setName(product.getName());
    }

    @DeleteMapping(path = "/product")
    public void deleteProduct(@RequestParam Long id) throws InterruptedException, ExecutionException {
        productRepository.deleteById(id);
    }

}
