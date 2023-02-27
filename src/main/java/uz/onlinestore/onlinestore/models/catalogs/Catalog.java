package uz.onlinestore.onlinestore.models.catalogs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import uz.onlinestore.onlinestore.models.ACTIVE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "catalog")
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

    public Catalog() {
    }

    public Catalog(Long id, @NonNull String catalogname, String imagepath, ACTIVE active, List<Catalog> catalogs, Catalog parent, List<Product> products) {
        this.id = id;
        this.catalogname = catalogname;
        this.imagepath = imagepath;
        this.active = active;
        this.catalogs = catalogs;
        this.parent = parent;
        this.products = products;
    }

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

//    @JsonIgnore
    public List<Catalog> getCatalogs() {
        List<Catalog> catalogslist = new ArrayList<>();
        if(this.catalogs != null){
            for (Catalog catalog : this.catalogs){
                if (catalog.active == ACTIVE.ACTIVE){
                    catalogslist.add(catalog);
                }
            }
        }

        return  catalogslist;
    }

    public Long getParentId() {
        if (parent != null) {
            return parent.getId();
        } else {
            return null;
        }
    }

    @JsonIgnore
    public Catalog getParent() {
        return parent;
    }

    public void setParent(Catalog parent) {
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatalogname() {
        return catalogname;
    }

    public void setCatalogname(String catalogname) {
        this.catalogname = catalogname;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public ACTIVE getActive() {
        return active;
    }

    public void setActive(ACTIVE active) {
        this.active = active;
    }

    public void setCatalogs(List<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}