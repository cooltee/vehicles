package com.cooltee.controller

import com.cooltee.service.interfaces.UserService
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
        @Autowired val userService: UserService
) {

    @RequestMapping(value = "/user", produces = arrayOf("application/json;charset=UTF-8"))
    @ResponseBody
    fun userData():String {
        return Gson().toJson(userService.queryAll())
    }
}