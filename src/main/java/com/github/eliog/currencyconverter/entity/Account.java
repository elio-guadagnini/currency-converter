package com.github.eliog.currencyconverter.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account", schema = "test_schema")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "created_on")
    @CreationTimestamp
    private Date createdOn;

    @Column(name = "last_login")
    @UpdateTimestamp
    private Date lastLogin;

    public Account() {
    }

    public Account(Long id, String username, String password, String email,
                   Date createdOn, Date lastLogin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdOn = createdOn;
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ExportingCurrencyValue{id=").append(id);
        sb.append(", username='").append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append('}');
        return sb.toString();
    }
}
