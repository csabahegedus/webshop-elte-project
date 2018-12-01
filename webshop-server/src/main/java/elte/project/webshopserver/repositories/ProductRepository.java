package elte.project.webshopserver.repositories;

import elte.project.webshopserver.entites.Product;
import elte.project.webshopserver.entites.Category;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);
}
