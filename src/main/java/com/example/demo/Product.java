package com.example.demo;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @SequenceGenerator(name="product_seq", sequenceName="product_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_seq")
    private long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private float price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Product() {
    }

    public Product(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public static List<Product> listAllProducts() throws SQLException {
        return DatabaseManager.listOfProducts();
    }
}
