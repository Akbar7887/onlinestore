package uz.onlinestore.onlinestore.models.catalogs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.onlinestore.onlinestore.models.ACTIVE;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "catalog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String catalogname;

    private String imagepath;


    @Enumerated(value = EnumType.STRING)
    private ACTIVE active = ACTIVE.ACTIVE;

    @OneToOne
    private Catalog catalog;

    @OneToMany(mappedBy = "catalog", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product product){
        if(!this.products.contains(product)){
            this.products.add(product);
            product.setCatalog(this);
        }
    }
    public void removeProduct(Product product){
        if(this.products.contains(product)){
            this.products.remove(product);
            product.setCatalog(null);
        }
    }


}