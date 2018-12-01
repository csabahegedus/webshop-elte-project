package elte.project.webshopserver.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product extends BaseEntity implements Serializable{
    @Column
    @NotNull
    private String manufacturer;
    
    @Column
    @NotNull
    private String modelNumber;
        
    @NotNull
    @Column
    private String description;
    
    @NotNull
    @ManyToOne(targetEntity = Category.class)
    private String category;
    
    @NotNull
    @Column
    private int price;
    
    @NotNull
    @Column
    private int quantity;
    
    @NotNull
    @Column
    private Boolean isActive;
}
