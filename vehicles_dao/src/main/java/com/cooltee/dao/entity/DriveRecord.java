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
@Table(name ="veh_drive_record")
public class DriveRecord extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "driver_id")
    private Long driver_id;

    @Column(name = "vehicle_id")
    private Long vehicle_id;

    @Column(name = "distance")
    private int distance;

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

    public void setDriver_id(Long driver_id) {
        this.driver_id = driver_id;
    }

    public Long getDriver_id() {
        return driver_id;
    }

    public void setVehicle_id(Long vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public Long getVehicle_id() {
        return vehicle_id;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
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
