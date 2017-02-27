package com.cooltee.dao.entity;

import com.cooltee.dao.orm.BaseEntity;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;


/**
 * TODO add distributions about this class
 * Created by alittleseven on 2017/2/18.
 */


@Entity
@Table(name = "veh_driver")
public class Driver extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private int gender;

    @Column(name = "id_card")
    private String id_card;

    @Column(name = "telphone")
    private String telphone;

    @Column(name = "allow_date")
    private Date allow_date;

    @Column(name = "allow_type")
    private String allow_type;

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

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getId_card() {
        return id_card;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setAllow_date(Date allow_date) {
        this.allow_date = allow_date;
    }

    public Date getAllow_date() {
        return allow_date;
    }

    public void setAllow_type(String allow_type) {
        this.allow_type = allow_type;
    }

    public String getAllow_type() {
        return allow_type;
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
