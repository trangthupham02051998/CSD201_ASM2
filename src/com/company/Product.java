package com.company;

import java.util.Objects;

public class Product {

    private Integer id;
    private String title;
    private Integer quantity;
    private double price;

    public Product() {

    }

    public Product(Integer id, String title, Integer quantity, double price) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%d  |  %s  |  %d  |  %.01f", id, title, quantity, price);
    }
}
