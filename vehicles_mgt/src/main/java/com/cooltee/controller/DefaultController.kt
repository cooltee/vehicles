package com.cooltee.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

/**
 * Controller of root
 * Created by Daniel on 2017/5/20.
 */
@Controller
@RequestMapping("/")
class DefaultController {

    @RequestMapping("index")
    fun index(): String {
        return "index"
    }

    @RequestMapping("login")
    fun login(request: HttpServletRequest, t: String?): String {
        request.setAttribute("redirectUrl", t)
        return "login"
    }

}