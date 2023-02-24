package uz.onlinestore.onlinestore.models.catalogs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import uz.onlinestore.onlinestore.models.ACTIVE;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonBackReference
    private Catalog catalog;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductImage> productImages = new ArrayList<ProductImage>();


    public void addProductImage(ProductImage productImage){
        if(!this.productImages.contains(productImage)){
            this.productImages.add(productImage);
            productImage.setProduct(this);
        }
    }
    public void removeProductImage(ProductImage productImage){
        if(this.productImages.contains(productImage)){
            this.productImages.remove(productImage);
            productImage.setProduct(null);
        }
    }


}