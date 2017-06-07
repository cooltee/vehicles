package com.cooltee.dao.entity;

import com.cooltee.dao.orm.BaseEntity;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private String registrationPlate;

    @Column(name = "manufacturers")
    private String manufacturers;

    @Column(name = "models")
    private String models;

    @Column(name = "vehicle_type")
    private int vehicleType;

    @Column(name = "vehicle_purpose")
    private int vehiclePurpose;

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;

    @Column(name = "purchase_dept")
    private String purchaseDept;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "archives_no")
    private String archivesNo;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;

    public Vehicle() {

    }

    public Vehicle(@NotNull String registrationPlate, @NotNull String manufacturers, @NotNull String models, int vehicleType, int vehiclePurpose, @NotNull BigDecimal purchasePrice, @NotNull String purchaseDept, @NotNull Date purchaseDate, @NotNull String archivesNo) {
        this.registrationPlate = registrationPlate;
        this.manufacturers = manufacturers;
        this.models = models;
        this.vehicleType = vehicleType;
        this.vehiclePurpose = vehiclePurpose;
        this.purchasePrice = purchasePrice;
        this.purchaseDept = purchaseDept;
        this.purchaseDate = purchaseDate;
        this.archivesNo = archivesNo;

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getVehiclePurpose() {
        return vehiclePurpose;
    }

    public void setVehiclePurpose(int vehiclePurpose) {
        this.vehiclePurpose = vehiclePurpose;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPurchaseDept() {
        return purchaseDept;
    }

    public void setPurchaseDept(String purchaseDept) {
        this.purchaseDept = purchaseDept;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getArchivesNo() {
        return archivesNo;
    }

    public void setArchivesNo(String archivesNo) {
        this.archivesNo = archivesNo;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}

