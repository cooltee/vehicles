package com.cooltee.controller

import com.cooltee.service.interfaces.SessionService
import com.cooltee.service.interfaces.UserService
import com.cooltee.util.getSessionId
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * controller of sign
 * Created by Daniel on 2017/5/4.
 */
@Controller
@RequestMapping("/sign")
class SignController(
        @Autowired private val userService: UserService,
        @Autowired private val sessionService: SessionService
) {

    private val logger = LogManager.getLogger(SignController::class)

    @RequestMapping(value = "/in", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun signIn(response: HttpServletResponse, username: String, password: String): String {
        logger.info(">>> $username sign in system ...")
        val result = userService.login(username, password)
        if (result == "success") {
            val sid = sessionService.getSessionInfo()!!.sid
            val cookie = Cookie("SIGNED_SID", sid)
            cookie.path = "/"
            //TODO set value static
            cookie.maxAge = -1
            response.addCookie(cookie)
            logger.info(">>> succeed!   sid=$sid")
        }
        return result
    }

    @RequestMapping("/out")
    @ResponseBody
    fun signOut(request: HttpServletRequest): String {
        val sid = getSessionId(request)
        userService.logout(sid)
        logger.info(">>> sign out!   sid=$sid")
        return "success"
    }
}