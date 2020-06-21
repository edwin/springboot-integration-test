package com.edw.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 *     com.edw.entity.Account
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 21 Jun 2020 22:04
 */
@Entity
@Table(name="t_accounts")
public class Account implements Serializable {
    @Id
    private Integer id;
    private String accountNumber;

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
