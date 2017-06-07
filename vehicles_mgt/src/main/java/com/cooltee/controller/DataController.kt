package com.cooltee.controller

import com.cooltee.service.interfaces.DataService
import com.cooltee.service.interfaces.UserService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * dataTables ajax request query data about validation json string
 * Created by Daniel on 2017/5/29.
 */
@Controller
@RequestMapping("/data")
class DataController(
        @Autowired val dataService: DataService,
        @Autowired val userService: UserService
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

    @RequestMapping(value = "/driverInfo", produces = arrayOf("application/json;charset=UTF-8"))
    @ResponseBody
    fun driverData(): String {
        return Gson().toJson(dataService.queryDrivers())
    }

    @RequestMapping(value = "/addUser", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun addUser(name: String, username: String): String {
        try {
            userService.save(name, username)
        } catch (e: Exception) {
            return e.localizedMessage
        }
        return "success"
    }
}