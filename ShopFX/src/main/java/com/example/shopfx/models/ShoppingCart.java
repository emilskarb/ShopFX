package com.example.shopfx.models;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class ShoppingCart {
    private final IntegerProperty id;
    private final StringProperty customer;
    private final ObjectProperty<LocalDateTime> date;
    private final ObservableList<Product> products;

    public ShoppingCart(int id, String customer, LocalDateTime date) {
        this.id = new SimpleIntegerProperty(id);
        this.customer = new SimpleStringProperty(customer);
        this.date = new SimpleObjectProperty<>(date);
        this.products = FXCollections.observableArrayList();
    }

    public int getId() { return id.get(); }
    public void setId(int id) { this.id.set(id); }
    public IntegerProperty idProperty() { return id; }

    public String getCustomer() { return customer.get(); }
    public void setCustomer(String customer) { this.customer.set(customer); }
    public StringProperty customerProperty() { return customer; }

    public LocalDateTime getDate() { return date.get(); }
    public void setDate(LocalDateTime date) { this.date.set(date); }
    public ObjectProperty<LocalDateTime> dateProperty() { return date; }

    public ObservableList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
}
