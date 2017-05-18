package com.cooltee.service.interfaces

import com.cooltee.session.SessionInfo

/**
 * The Interface of Session Service
 * Created by Daniel on 2017/5/16.
 */
interface SessionService {

    fun getSessionInfo(): SessionInfo?

    fun checkSigned(sessionId: String): Boolean

    fun destroyCache()

    fun refreshEffective(sessionId: String)

    fun save(sessionInfo: SessionInfo)
}