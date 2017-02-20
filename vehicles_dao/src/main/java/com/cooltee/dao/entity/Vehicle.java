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
@Table(name = "veh_vehicle")
public class Vehicle extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private  Long id;

    @Column(name = "registration_plate")
    private String registration_plate;

    @Column(name = "manufacturers")
    private String manufacturers;

    @Column(name = "models")
    private String models;

    @Column(name = "vehicle_type")
    private int vehicle_type;

    @Column(name = "vehicle_purpose")
    private int vehicle_purpose;

    @Column(name = "purchase_price")
    private double purchase_price;

    @Column(name = "purchase_dept")
    private String purchase_dept;

    @Column(name = "purchase_date")
    private Date purchase_date;

    @Column(name = "archives_no")
    private String archives_no;

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

    public void setRegistration_plate(String registration_plate) {
        this.registration_plate = registration_plate;
    }

    public String getRegistration_plate() {
        return registration_plate;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public String getModels() {
        return models;
    }

    public void setVehicle_type(int vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public int getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_purpose(int vehicle_purpose) {
        this.vehicle_purpose = vehicle_purpose;
    }

    public int getVehicle_purpose() {
        return vehicle_purpose;
    }

    public void setPurchase_price(double purchase_price) {
        this.purchase_price = purchase_price;
    }

    public double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_dept(String purchase_dept) {
        this.purchase_dept = purchase_dept;
    }

    public String getPurchase_dept() {
        return purchase_dept;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setArchives_no(String archives_no) {
        this.archives_no = archives_no;
    }

    public String getArchives_no() {
        return archives_no;
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

