package com.cooltee.service.impl

import com.cooltee.dao.entity.Vehicle
import com.cooltee.dao.interfaces.VehicleDao
import com.cooltee.service.interfaces.DataOperateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.sql.Date

/**
 * the Implement of Data operate service
 * Created by Daniel on 2017/6/7.
 */
@Service
@Transactional
class DataOperateServiceImpl(
        @Autowired val vehicleDao: VehicleDao
) : DataOperateService {
    override fun saveVehicle(registrationPlate: String, manufacturers: String, models: String, vehicleType: Int, vehiclePurpose: Int, purchasePrice: BigDecimal, purchaseDept: String, purchaseDate: Date, archivesNo: String) {
        val vehicle = Vehicle(registrationPlate, manufacturers, models, vehicleType, vehiclePurpose, purchasePrice, purchaseDept, purchaseDate, archivesNo)
        vehicleDao.save(vehicle)
    }


}