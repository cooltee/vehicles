package com.cooltee.mgt.controller

import com.cooltee.service.interfaces.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * controller of login
 * Created by Daniel on 2017/5/4.
 */
@Controller
@RequestMapping(value = "/login", method = arrayOf(RequestMethod.POST))
class LoginController(@Autowired private val userService: UserService) {

    @RequestMapping("do")
    fun login(username: String, password: String): String{
        return userService.login(username, password)

    }
}