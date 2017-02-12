package com.cooltee.dao.entity;

import com.cooltee.dao.orm.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO add distributions about this class
 * Created by Daniel on 2017/2/12.
 */
@Entity
@Table(name = "veh_user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
