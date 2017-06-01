package com.cooltee.controller

import com.cooltee.service.interfaces.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

/**
 * Controller of root
 * Created by Daniel on 2017/5/20.
 */
@Controller
@RequestMapping("/")
class DefaultController(@Autowired val userService: UserService) {

    @RequestMapping("index")
    fun index(): String {
        return "index"
    }

    @RequestMapping("login")
    fun login(request: HttpServletRequest, t: String?): String {
        request.setAttribute("redirectUrl", t)
        return "login"
    }

    @RequestMapping(value = "chgPass", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun changePass(original: String, new: String): String {
        try {
            userService.changePass(original, new)
        } catch (e: Exception) {
            return e.message!!
        }
        return "success"
    }

}