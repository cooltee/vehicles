package com.cooltee.dao.entity;

import com.cooltee.dao.orm.BaseEntity;
import com.sun.org.apache.xpath.internal.operations.String;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * TODO add distributions about this class
 * Created by alittleseven on 2017/2/19.
 */

@Entity
@Table(name ="veh_repair_record")
public class RepairRecord extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "cost_id")
    private int cost_id;

    @Column(name = "description")
    private String description;

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

    public void setCost_id(int cost_id) {
        this.cost_id = cost_id;
    }

    public int getCost_id() {
        return cost_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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
