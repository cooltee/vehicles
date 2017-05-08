package com.cooltee.interceptor

import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 登录拦截器，校验用户登录信息
 * Created by Daniel on 2017/5/6.
 */
class SignedInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse?, any: Any?): Boolean {
        var sid: String = ""
        request.cookies.map{if("userSignedSID" == it.name){sid = it.value}}
        if (sid != "") {

        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?, any: Any?, mav: ModelAndView?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?, any: Any?, e: Exception?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}