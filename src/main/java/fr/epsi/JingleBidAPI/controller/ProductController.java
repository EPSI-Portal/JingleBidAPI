package fr.epsi.JingleBidAPI.controller;

import fr.epsi.JingleBidAPI.model.Product;
import fr.epsi.JingleBidAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping(path = "/product")
    public @ResponseBody Product postProduct(@RequestBody Product product) throws InterruptedException, ExecutionException {
        Product product1 = new Product();
        System.out.println(product.toString());
        System.out.println(product1);
        product1.setName(product.getName());
        product1.setCondition(product.getCondition());
        product1.setImage(product.getImage());
        product1.setLongDesc(product.getLongDesc());
        product1.setShortDesc(product.getShortDesc());
        product1.setPrice(product.getPrice());
        product1.setCreatedAt(product.getCreatedAt());
        return productRepository.save(product1);
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
            product1.setCondition(product.getCondition());
            product1.setImage(product.getImage());
            product1.setLongDesc(product.getLongDesc());
            product1.setShortDesc(product.getShortDesc());
            product1.setPrice(product.getPrice());
            product1.setCreatedAt(product.getCreatedAt());
             productRepository.save(product1);
        }
    }


    @DeleteMapping(path = "/product/{id}")
    public @ResponseBody String deleteProduct(@PathVariable Long id) throws InterruptedException, ExecutionException {
        Optional<Product> productOptional = productRepository.findById(id) ;
        if(productOptional.isPresent()) {
            productRepository.deleteById(id);
            return "Le produit avec l'id " + id + " a été supprimé" ;

        }
        return "ID introuvable";
    }

}
