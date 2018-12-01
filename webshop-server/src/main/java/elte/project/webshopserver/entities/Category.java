package elte.project.webshopserver.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Category extends BaseEntity implements Serializable {
    @NotNull
    @Column
    private String name;

    @JoinColumn(updatable = false)
    @OneToMany(targetEntity = Product.class, mappedBy = "category")
    private List<Product> products;
   
}
