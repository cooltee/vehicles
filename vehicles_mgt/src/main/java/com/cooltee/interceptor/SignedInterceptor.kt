package com.cooltee.interceptor

import com.cooltee.service.interfaces.SessionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 登录拦截器，校验用户登录信息
 * Created by Daniel on 2017/5/6.
 */
@Component
open class SignedInterceptor(@Autowired private val sessionService: SessionService) : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, any: Any?): Boolean {
        val sid = getSessionId(request)

        if (sid != "") {
            if (sessionService.checkSigned(sid)) {
                return true
            }
        }

        //跳转至登陆页
        val redirectUrl = request.contextPath + "/login?t=" + request.requestURI
        response.sendRedirect(redirectUrl)
        return false
    }

    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse?, any: Any?, mav: ModelAndView?) {
        sessionService.destroyCache()
        sessionService.refreshEffective(getSessionId(request))
    }

    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?, any: Any?, e: Exception?) {
    }

    private fun getSessionId(request: HttpServletRequest): String {
        var sessionId = ""
        request.cookies?.map{
            if("SIGNED_SID" == it.name){
                sessionId = it.value
            }
        }
        return sessionId
    }
}