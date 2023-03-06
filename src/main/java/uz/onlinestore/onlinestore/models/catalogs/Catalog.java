package uz.onlinestore.onlinestore.models.catalogs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.NonNull;
import uz.onlinestore.onlinestore.models.ACTIVE;

import java.util.List;

@Entity
@Table(name = "catalog")
public class Catalog {

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
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Catalog> catalogs;

    @ManyToOne()
    @JoinColumn(name = "parent_id",
            referencedColumnName = "id")
    @JsonBackReference
    private Catalog parent;

//    @OneToMany(mappedBy = "catalog",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<Product> products = new ArrayList<>();


    public Catalog() {
    }

    public Catalog(Long id, @NonNull String catalogname, String imagepath, ACTIVE active, List<Catalog> catalogs, Catalog parent) {
        this.id = id;
        this.catalogname = catalogname;
        this.imagepath = imagepath;
        this.active = active;
        this.parent = parent;
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

    public List<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(List<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public Catalog getParent() {
        return parent;
    }

    public void setParent(Catalog parent) {
        this.parent = parent;
    }




}