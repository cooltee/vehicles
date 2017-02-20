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
@Table(name ="veh_oil_record")
public class OilRecord extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "cost_id")
    private Long cost_id;

    @Column(name = "oil_price")
    private double oil_price;

    @Column(name = "oil_volume")
    private double oil_volume;

    @Column(name = "oil_discount")
    private double oil_discount;

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

    public void setCost_id(Long cost_id) {
        this.cost_id = cost_id;
    }

    public Long getCost_id() {
        return cost_id;
    }

    public void setOil_price(double oil_price) {
        this.oil_price = oil_price;
    }

    public double getOil_price() {
        return oil_price;
    }

    public void setOil_volume(double oil_volume) {
        this.oil_volume = oil_volume;
    }

    public double getOil_volume() {
        return oil_volume;
    }

    public void setOil_discount(double oil_discount) {
        this.oil_discount = oil_discount;
    }

    public double getOil_discount() {
        return oil_discount;
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
