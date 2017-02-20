package com.cooltee.dao.entity;

import com.cooltee.dao.orm.BaseEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;


/**
 * TODO add distributions about this class
 * Created by alittleseven on 2017/2/19.
 */

@Entity
@Table(name = "veh_cost")
public class Cost extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "vehicle_id")
    private int vehicle_id;

    @Column(name = "amount")
    private String amount;

    @Column(name = "cost_type")
    private int cost_type;

    @Column(name = "spend_date")
    private Date spend_date;

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

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setCost_type(int cost_type) {
        this.cost_type = cost_type;
    }

    public int getCost_type() {
        return cost_type;
    }

    public void setSpend_date(Date spend_date) {
        this.spend_date = spend_date;
    }

    public Date getSpend_date() {
        return spend_date;
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
