package com.cooltee.util

import javax.servlet.http.HttpServletRequest

/**
 * TODO add distributions about this class
 * Created by Daniel on 2017/5/24.
 */

fun getSessionId(request: HttpServletRequest): String {
    var sessionId = ""
    request.cookies?.map{
        if("SIGNED_SID" == it.name){
            sessionId = it.value
        }
    }
    return sessionId
}