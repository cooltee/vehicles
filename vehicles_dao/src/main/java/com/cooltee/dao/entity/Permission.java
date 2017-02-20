package com.cooltee.dao.entity;

import com.cooltee.dao.orm.BaseEntity;
import org.hibernate.annotations.Cache;


import javax.persistence.*;
import java.sql.Timestamp;


/**
 * TODO add distributions about this class
 * Created by alittleseven on 2017/2/19.
 */

@Entity
@Table(name = "veh_permission")
public class Permission extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "permission_code")
    private String permission_code;

    @Column(name = "create_time")
    private Timestamp create_time;

    @Column(name = "update_time")
    private Timestamp update_time;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPermission_code(String permission_code) {
        this.permission_code = permission_code;
    }

    public String getPermission_code() {
        return permission_code;
    }

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
