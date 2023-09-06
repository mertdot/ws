package com.businesscard.ws.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data //lombok contructorları getter setteri gibi bir çok methodu otomatik ekliyor.
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String displayName;

    private String password;

    public User(long id, String username, String displayName, String password) {
        this.id = id;
        this.username = username;
        this.displayName = displayName;
        this.password = password;
    }

    public User() {

    }
}
