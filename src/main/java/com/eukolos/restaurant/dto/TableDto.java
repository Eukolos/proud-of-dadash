package com.eukolos.restaurant.dto;

import com.eukolos.restaurant.model.Table;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Table} entity
 */
public class TableDto implements Serializable {
    private String id;
    private int number;

    public TableDto() {
    }

    public TableDto(String id, int number) {
        this.id = id;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public TableDto setId(String id) {
        this.id = id;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public TableDto setNumber(int number) {
        this.number = number;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableDto entity = (TableDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.number, entity.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "number = " + number + ")";
    }
}