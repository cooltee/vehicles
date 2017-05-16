package com.cooltee.controller

import com.cooltee.service.interfaces.UserService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

/**
 * controller of login
 * Created by Daniel on 2017/5/4.
 */
@Controller
@RequestMapping("/")
class LoginController(@Autowired private val userService: UserService) {

    private val logger = LogManager.getLogger(LoginController::class)

    @RequestMapping("index")
    fun index(): String {
        return "index"
    }

    @RequestMapping("login")
    fun login(request: HttpServletRequest, url: String?): String {
        request.setAttribute("redirectUrl", url)
        return "login"
    }

    @RequestMapping(value = "doLogin", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun doLogin(username: String, password: String): String {
        return userService.login(username, password)
    }

}