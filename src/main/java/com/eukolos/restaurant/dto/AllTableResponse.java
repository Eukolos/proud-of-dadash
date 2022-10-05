package com.eukolos.restaurant.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.eukolos.restaurant.model.Table} entity
 */
public class AllTableResponse implements Serializable{
    private String id;
    private int number;
    private List<AccountIdResponse> accountList;


    public AllTableResponse(String id, int number, List<AccountIdResponse> accountList) {
        this.id = id;
        this.number = number;
        this.accountList = accountList;
    }

    public AllTableResponse() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAccountList(List<AccountIdResponse> accountList) {
        this.accountList = accountList;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public List<AccountIdResponse> getAccountList() {
        return accountList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllTableResponse entity = (AllTableResponse) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.number, entity.number) &&
                Objects.equals(this.accountList, entity.accountList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, accountList);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "number = " + number + ", " +
                "accountList = " + accountList + ")";
    }
}