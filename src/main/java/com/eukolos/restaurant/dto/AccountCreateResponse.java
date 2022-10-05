package com.eukolos.restaurant.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.eukolos.restaurant.model.Account} entity
 */
public class AccountCreateResponse implements Serializable {
    private String id;
    private Boolean isActive;
    private TableAccountCreateResponse table;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AccountCreateResponse() {
    }

    public AccountCreateResponse(String id, Boolean isActive, TableAccountCreateResponse table, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.isActive = isActive;
        this.table = table;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public AccountCreateResponse setId(String id) {
        this.id = id;
        return this;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public AccountCreateResponse setIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public TableAccountCreateResponse getTable() {
        return table;
    }

    public AccountCreateResponse setTable(TableAccountCreateResponse table) {
        this.table = table;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public AccountCreateResponse setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public AccountCreateResponse setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCreateResponse entity = (AccountCreateResponse) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.isActive, entity.isActive) &&
                Objects.equals(this.table, entity.table) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActive, table, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "isActive = " + isActive + ", " +
                "table = " + table + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ")";
    }
}