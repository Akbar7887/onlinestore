package uz.onlinestore.onlinestore.models.catalogs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.NonNull;
import uz.onlinestore.onlinestore.models.ACTIVE;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imagepath;


    @Enumerated(value = EnumType.STRING)
    private ACTIVE active = ACTIVE.ACTIVE;


    @ManyToOne()
    @JoinColumn(name = "catalog_id", referencedColumnName = "id")
//    @JsonBackReference
    private Catalog catalog;

//    @OneToMany(mappedBy = "product",
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<ProductImage> productImages = new ArrayList<ProductImage>();

//    @OneToMany(mappedBy = "product",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
////    @JsonManagedReference
//    private List<Characteristic> characteristics = new ArrayList<>();


//    public void addProductImage(ProductImage productImage) {
//        if (!this.productImages.contains(productImage)) {
//            this.productImages.add(productImage);
//            productImage.setProduct(this);
//        }
//    }
//
//    public void removeProductImage(ProductImage productImage) {
//        if (this.productImages.contains(productImage)) {
//            this.productImages.remove(productImage);
//            productImage.setProduct(null);
//        }
//    }

    public Product() {
    }

    public Product(Long id, @NonNull String name, String description, String imagepath, ACTIVE active, Catalog catalog) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagepath = imagepath;
        this.active = active;
        this.catalog = catalog;
//        this.productImages = productImages;
//        this.characteristics = characteristics;
    }

//    public void addCharacteristic(Characteristic characteristic) {
//        if (!this.characteristics.contains(characteristic)) {
//            this.characteristics.add(characteristic);
//            characteristic.setProduct(this);
//        }
//    }
//
//    public void removeCharacteristic(Characteristic characteristic) {
//        if (this.characteristics.contains(characteristic)) {
//            this.characteristics.remove(characteristic);
//            characteristic.setProduct(null);
//        }
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

//    public List<ProductImage> getProductImages() {
//        return productImages;
//    }
//
//    public void setProductImages(List<ProductImage> productImages) {
//        this.productImages = productImages;
//    }

    public Long getCatalogId() {
        return this.catalog.getId();
    }

//    @JsonIgnore
//    public List<Characteristic> getCharacteristics() {
//
//        return characteristics;
//    }

//    public void setCharacteristics(List<Characteristic> characteristics) {
//        this.characteristics = characteristics;
//    }

}