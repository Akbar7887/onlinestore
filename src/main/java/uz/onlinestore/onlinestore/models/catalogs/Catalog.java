package uz.onlinestore.onlinestore.models.catalogs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import uz.onlinestore.onlinestore.models.ACTIVE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "catalog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id",
            referencedColumnName = "id")
    @JsonBackReference
    private Catalog parent;

    @OneToMany(mappedBy = "catalog",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (!this.products.contains(product)) {
            this.products.add(product);
            product.setCatalog(this);
        }
    }

    public void removeProduct(Product product) {
        if (this.products.contains(product)) {
            this.products.remove(product);
            product.setCatalog(null);
        }
    }

    public void addCatalog(Catalog catalog) {
        if (!this.catalogs.contains(catalog)) {
            this.catalogs.add(catalog);
            catalog.setParent(this);
        }
    }

    public void removeCatalog(Catalog catalog) {
        if (this.catalogs.contains(catalog)) {
            this.catalogs.remove(catalog);
            catalog.setParent(null);
        }
    }

    @JsonIgnore
    public List<Catalog> getCatalogs() {
        return catalogs;
    }

    public Long getParentId() {
        if (parent != null) {
            return parent.getId();
        } else {
            return null;
        }
    }

    //    @JsonIgnore
    public Catalog getParent() {
        return parent;
    }

    public void setParent(Catalog parent) {
        this.parent = parent;
    }
}