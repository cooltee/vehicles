package com.cooltee.dao.entity;

import com.cooltee.dao.orm.BaseEntity;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.Date;

/**
 * entity of user
 * Created by Daniel on 2017/2/12.
 */

@Entity
@Table(name = "veh_user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "state")
    private int state;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "update_time")
    private Date update_time;


    @Override
    public void setId(Long id) { this.id = id; }

    @Override
    public Long getId() { return id; }

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }

    public void setPassword(String password) { this.password = password; }

    public String getPassword() { return password; }

    public void setState(int state) { this.state = state; }

    public int getState() { return state; }

    public void setCreate_time(Date create_time) { this.create_time = create_time; }

    public Date getCreate_time() { return create_time; }

    public void setUpdate_time(Date update_time) { this.update_time = update_time; }

    public Date getUpdate_time() { return update_time; }
}
