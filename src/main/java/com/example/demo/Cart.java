package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "cart")
    @ElementCollection
    private List<Product> productsInCart = new ArrayList<>();

    private ArrayList<Integer> quantities = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public void addItem(Product product) {
        if (productsInCart.contains(product)) {
            int quantity = quantities.get(productsInCart.indexOf(product));
            int index = productsInCart.indexOf(product);
            quantities.set(index, quantity + 1);
        }
        else {
            productsInCart.add(product);
            quantities.add(productsInCart.indexOf(product), 1);
        }
    }

    public float calculateTotal() {
        return productsInCart.stream().map(i -> i.getPrice() * quantities.get(productsInCart.indexOf(i)))
                .reduce(0F, (a, b) -> a + b);
    }
}
