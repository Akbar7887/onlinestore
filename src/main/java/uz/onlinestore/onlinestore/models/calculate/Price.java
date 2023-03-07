package uz.onlinestore.onlinestore.models.calculate;

import jakarta.persistence.*;
import uz.onlinestore.onlinestore.models.catalogs.Product;

import java.util.Date;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Enumerated(EnumType.STRING)
    private RATES rates = RATES.USD;

    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Price() {
    }

    public Price(Long id, Date date, RATES rates, double price, Product product) {
        this.id = id;
        this.date = date;
        this.rates = rates;
        this.price = price;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RATES getRates() {
        return rates;
    }

    public void setRates(RATES rates) {
        this.rates = rates;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}