package elte.project.webshopserver.controllers;

import elte.project.webshopserver.entities.BaseEntity;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public abstract class BaseController<T extends BaseEntity, R extends CrudRepository<T, Long>> {
    @Autowired
    private R repository;

    public R getRepository() {
        return repository;
    }
  
        
    protected <T extends BaseEntity> Optional<T> getEntity(Long id){
        return (Optional<T>) repository.findById(id);
    }

    protected T saveEntity(T baseEntity){
        return repository.save(baseEntity);
    }
    
    protected void deleteEntity(Long Id){
        repository.deleteById(Id);
    }
    
    
    @GetMapping("")
    public ResponseEntity<Iterable<T>> getAll() {
        return new ResponseEntity(repository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable Long id) {
        Optional<T> baseEntity = getEntity(id);
        if (baseEntity.isPresent()) {
            return (ResponseEntity<T> )ResponseEntity.ok(baseEntity.get());
        } 
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("")
    public ResponseEntity<T> post(@RequestBody T baseEntity) {
        T savedBaseEntity = saveEntity(baseEntity);
        return ResponseEntity.ok(savedBaseEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<T> originalBaseEntity = getEntity(id);
        if (originalBaseEntity.isPresent()) {
            deleteEntity(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> put(@PathVariable Long id, @RequestBody T baseEntity) {
        Optional<T> originalBaseEntity = getEntity(id);
        if (originalBaseEntity.isPresent()) {
            baseEntity.setId(id);
            return ResponseEntity.ok(saveEntity(baseEntity));
        }
        return ResponseEntity.notFound().build();
    }
    

    

}