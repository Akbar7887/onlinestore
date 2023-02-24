package uz.onlinestore.onlinestore.models.catalogs;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import uz.onlinestore.onlinestore.models.ACTIVE;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "catalog")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties({"hibernate_lazy_initializer", "handler"})
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @EqualsAndHashCode.Include
    private Long id;

    @NonNull
    private String catalogname;

    private String imagepath;


    @Enumerated(value = EnumType.STRING)
    private ACTIVE active = ACTIVE.ACTIVE;

    @OneToMany(mappedBy = "parent",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Catalog> catalogs;

    @ManyToOne()
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @JsonBackReference
    private Catalog parent;

    @OneToMany(mappedBy = "catalog", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

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

    public void addCatalog(Catalog catalog){
        if(!this.catalogs.contains(catalog)){
            this.catalogs.add(catalog);
            catalog.setParent(this);
        }
    }
    public void removeCatalog(Catalog catalog){
        if(this.catalogs.contains(catalog)){
            this.catalogs.remove(catalog);
            catalog.setParent(null);
        }
    }

    @JsonIgnore
    public List<Catalog> getCatalogs() {
        return catalogs;
    }
}