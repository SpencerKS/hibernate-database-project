package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public void createNewProduct(Product product) {
        //do something
    }
    public List<Product> readAllProducts() throws SQLException {
        return DatabaseManager.listOfProducts();
    }
    public void updateProduct(long id, String productString) {
        //do something
    }
    public void deleteProduct(long id) {
        //do something
    }
}
