package com.cooltee.service.impl

import com.cooltee.dao.entity.Driver
import com.cooltee.dao.entity.User
import com.cooltee.dao.entity.Vehicle
import com.cooltee.dao.interfaces.DriverDao
import com.cooltee.dao.interfaces.UserDao
import com.cooltee.dao.interfaces.VehicleDao
import com.cooltee.service.interfaces.DataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * TODO add distributions about this class
 * Created by Daniel on 2017/5/29.
 */
@Service
class DataServiceImpl(
        @Autowired val userDao: UserDao,
        @Autowired val vehicleDao: VehicleDao,
        @Autowired val driverDao: DriverDao
) : DataService {

    override fun queryUsers(): MutableList<User> {
        return userDao.findAll()
    }

    override fun queryVehicles(): MutableList<Vehicle> {
        return vehicleDao.findAll()
    }

    override fun queryDrivers(): MutableList<Driver> {
        return driverDao.findAll()
    }
}