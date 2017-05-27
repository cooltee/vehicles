package com.cooltee.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * controller of pages
 * Created by Daniel on 2017/5/20.
 */
@Controller
@RequestMapping("/page")
class PageController {

    @RequestMapping("/welcome")
    fun welcome(): String {
        return "page/welcome"
    }

    @RequestMapping("/userInfo")
    fun userInfo(): String {
        return "page/info/user"
    }

    @RequestMapping("/vehicleInfo")
    fun vehicleInfo(): String {
        return "page/info/vehicle"
    }

    @RequestMapping("/driverInfo")
    fun driverInfo(): String {
        return "page/info/driver"
    }

    @RequestMapping("/repairCost")
    fun repairCost(): String {
        return "page/cost/repair"
    }

    @RequestMapping("/energyCost")
    fun energyCost(): String {
        return "page/cost/energy"
    }

    @RequestMapping("/parkingCost")
    fun parkingCost(): String {
        return "page/cost/parking"
    }

    @RequestMapping("/otherCost")
    fun otherCost(): String {
        return "page/cost/other"
    }
}