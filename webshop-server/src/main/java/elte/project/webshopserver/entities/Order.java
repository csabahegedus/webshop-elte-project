package elte.project.webshopserver.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order extends BaseEntity implements Serializable{
    @Column
    @NotNull
    private String name;
    
    @Column
    @NotNull
    private String address;
        
    @NotNull
    @Column
    private String phoneNumber;
    
    @NotNull
    @Column
    private String email;
    
    @NotNull
    @OneToMany(targetEntity = Product.class)
    private List<Product> products;
    
    @NotNull
    @Column
    private Boolean isCompleted;

}
