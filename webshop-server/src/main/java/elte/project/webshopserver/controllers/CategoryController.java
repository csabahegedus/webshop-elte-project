package elte.project.webshopserver.controllers;

import elte.project.webshopserver.entites.Product;
import elte.project.webshopserver.entites.Category;
import elte.project.webshopserver.repositories.ProductRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("categories")
public class CategoryController extends BaseController<Category, ProductRepository> {
    
    @Autowired
    private ProductRepository productRepository;
    
    
    @GetMapping("/{id}/products")
    public ResponseEntity<Iterable<Product>> products(@PathVariable Long id) {
        Optional<Product> originalProduct = getEntity(id);
        if (originalProduct.isPresent()) {
            return ResponseEntity.ok(originalProduct.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
