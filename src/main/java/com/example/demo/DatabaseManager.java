package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String url = "jdbc:postgresql://localhost:5432/shoppingDB";
    private static final String user = "spencer";
    private static final String password = "password";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static ResultSet readAllProducts() throws SQLException {
        String SQL = "select * from products";
        Statement stmt = connect().createStatement();
        return stmt.executeQuery(SQL);
    }

    public static List<Product> listOfProducts() throws SQLException {
        ResultSet resultSet = readAllProducts();
        List<Product> productList = new ArrayList<>();
        while(resultSet.next()) {
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("product_name");
            float price = resultSet.getFloat("product_price");
            if (resultSet.getString("brand") != null) {
                String type = resultSet.getString("type");
                String brand = resultSet.getString("brand");
                String design = resultSet.getString("design");
                Product apparel = new Apparel(id, name, price, type, brand, design);
                productList.add(apparel);
            }
            else if (resultSet.getString("author") != null) {
                String genre = resultSet.getString("genre");
                String author = resultSet.getString("author");
                int publication = resultSet.getInt("publication");
                Product book = new Book(id, name, price, genre, author, publication);
                productList.add(book);
            }
        }
        return productList;
    }
}
