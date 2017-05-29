package com.cooltee.controller

import com.cooltee.service.interfaces.DataService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * dataTables ajax request query data about validation json string
 * Created by Daniel on 2017/5/29.
 */
@Controller
@RequestMapping("/data")
class DataController(
        @Autowired val dataService: DataService
) {

    @RequestMapping(value = "/userInfo", produces = arrayOf("application/json;charset=UTF-8"))
    @ResponseBody
    fun userData(): String {
        return Gson().toJson(dataService.queryUsers())
    }

    @RequestMapping(value = "/vehicleInfo", produces = arrayOf("application/json;charset=UTF-8"))
    @ResponseBody
    fun vehicleData(): String {
        return Gson().toJson(dataService.queryVehicles())
    }
}