package com.cooltee.dao.impl;

import com.cooltee.dao.entity.Vehicle;
import com.cooltee.dao.interfaces.VehicleDao;
import com.cooltee.dao.orm.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * dao of vehicle
 * Created by alittleseven on 2017/2/20.
 */
@Repository
public class VehicleDaoImpl extends BaseDaoImpl<Vehicle> implements VehicleDao {
}
