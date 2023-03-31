package fr.epsi.JingleBidAPI.repository;

import fr.epsi.JingleBidAPI.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
