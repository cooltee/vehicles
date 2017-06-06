package com.cooltee.dao.entity;

import com.cooltee.dao.orm.BaseEntity;
import org.hibernate.annotations.Cache;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * entity of user
 * Created by Daniel on 2017/2/12.
 */

@Entity
@Table(name = "veh_user")
public class User extends BaseEntity implements Serializable {

    public static final String DEFAULT_PASSWORD = "123456";
    public static final int DEFAULT_STATE = 1;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "state")
    private int state;

    @Column(name = "create_time")
    private Timestamp create_time;

    @Column(name = "update_time")
    private Timestamp update_time;

    public User(){

    }

    public User(@NotNull String name, @NotNull String username, @NotNull String password, int state) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.state = state;
    }

    @Override
    public void setId(Long id) { this.id = id; }

    @Override
    public Long getId() { return id; }

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) { this.password = password; }

    public String getPassword() { return password; }

    public void setState(int state) { this.state = state; }

    public int getState() { return state; }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }
}
