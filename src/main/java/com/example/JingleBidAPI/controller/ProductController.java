package com.example.JingleBidAPI.controller;

import com.example.JingleBidAPI.model.Product;
import com.example.JingleBidAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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
    public Product getProductDetails(@PathVariable Long id) throws InterruptedException, ExecutionException {
        Optional<Product> productOptional = productRepository.findById(id) ;
        if(productOptional.isPresent())
            return productOptional.get() ;
        else
            return null ;
    }

    @PutMapping(path = "/product/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable Long id ) throws InterruptedException, ExecutionException {

        Optional<Product> productOptional = productRepository.findById(id) ;
        if(productOptional.isPresent()) {
             Product product1 = productOptional.get();
             product1.setName(product.getName());
             productRepository.save(product1);
        }
    }


    @DeleteMapping(path = "/product/{id}")
    public void deleteProduct(@PathVariable Long id) throws InterruptedException, ExecutionException {
        productRepository.deleteById(id);
    }

}
