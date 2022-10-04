package com.eukolos.restaurant.dto;

import com.eukolos.restaurant.model.Account;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link Account} entity
 */
public class AccountDto implements Serializable {
    private String id;
    private Boolean isActive;
    private List<List<String>> product;
    private String table;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AccountDto() {
    }

    public AccountDto(String id, Boolean isActive, List<List<String>> product, String table, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.isActive = isActive;
        this.product = product;
        this.table = table;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public AccountDto setId(String id) {
        this.id = id;
        return this;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public AccountDto setIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public List<List<String>> getProduct() {
        return product;
    }

    public AccountDto setProduct(List<List<String>> product) {
        this.product = product;
        return this;
    }

    public String getTable() {
        return table;
    }

    public AccountDto setTable(String table) {
        this.table = table;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public AccountDto setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public AccountDto setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto entity = (AccountDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.isActive, entity.isActive) &&
                Objects.equals(this.product, entity.product) &&
                Objects.equals(this.table, entity.table) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActive, product, table, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "isActive = " + isActive + ", " +
                "product = " + product + ", " +
                "table = " + table + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ")";
    }
}