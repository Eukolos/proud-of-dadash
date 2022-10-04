package com.eukolos.restaurant.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.eukolos.restaurant.model.Product} entity
 */
public class ProductDto implements Serializable {
    private String id;
    private String name;
    private double amount;
    private double price;

    public ProductDto() {
    }

    public ProductDto(String id, String name, double amount, double price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public ProductDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public ProductDto setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductDto setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto entity = (ProductDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.price, entity.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount, price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "amount = " + amount + ", " +
                "price = " + price + ")";
    }
}