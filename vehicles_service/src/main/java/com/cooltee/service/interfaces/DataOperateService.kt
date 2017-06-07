package com.cooltee.service.interfaces

import java.math.BigDecimal
import java.sql.Date

/**
 * The Interface of Data Operate Service
 * Created by Daniel on 2017/6/7.
 */
interface DataOperateService {
    fun saveVehicle(registrationPlate: String, manufacturers: String, models: String, vehicleType: Int, vehiclePurpose: Int, purchasePrice: BigDecimal, purchaseDept: String, purchaseDate: Date, archivesNo: String)
}