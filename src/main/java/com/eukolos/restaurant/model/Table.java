package com.eukolos.restaurant.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity(name = "table_")
public class Table {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private int number;

    @OneToMany(mappedBy = "table")
    private List<Account> accountList;

    public Table() {
    }

    public Table(String id, int number, List<Account> accountList) {
        this.id = id;
        this.number = number;
        this.accountList = accountList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table)) return false;
        Table table = (Table) o;
        return number == table.number && Objects.equals(id, table.id) && Objects.equals(accountList, table.accountList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, accountList);
    }

    @Override
    public String toString() {
        return "Table{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", accountList=" + accountList +
                '}';
    }
}
