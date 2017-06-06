package com.cooltee.service.interfaces

import com.cooltee.dao.entity.Driver
import com.cooltee.dao.entity.User
import com.cooltee.dao.entity.Vehicle

/**
 * TODO add distributions about this class
 * Created by Daniel on 2017/5/29.
 */
interface DataService {
    fun queryUsers(): MutableList<User>
    fun queryVehicles(): MutableList<Vehicle>
    fun queryDrivers(): MutableList<Driver>
}