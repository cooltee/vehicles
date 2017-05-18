package com.cooltee.service.impl

import com.cooltee.dao.interfaces.UserDao
import com.cooltee.redis.RedisClient
import com.cooltee.service.interfaces.SessionService
import com.cooltee.session.SessionInfo
import com.cooltee.util.StringUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * The Implements of Session Service
 * Created by Daniel on 2017/5/16.
 */
@Service
class SessionServiceImpl(@Autowired private val userDao: UserDao) : SessionService {

    private val cache: ThreadLocal<SessionInfo> = ThreadLocal<SessionInfo>()

    override fun getSessionInfo(): SessionInfo? {
        return cache.get()
    }

    override fun checkSigned(sessionId: String): Boolean {
        var sessionInfo = RedisClient.get(sessionId) as SessionInfo?
        if (sessionInfo == null) {
            sessionInfo = SessionInfo(StringUtil.generateUUID(), null)
        }
        val flag = sessionId == sessionInfo.sid
        if (flag) {
            cache.set(sessionInfo)
        }
        return flag
    }

    override fun destroyCache() {
        cache.remove()
    }

    override fun refreshEffective(sessionId: String) {
        RedisClient.expire(sessionId, 1800)
    }

    override fun save(sessionInfo: SessionInfo) {
        cache.set(sessionInfo)
        RedisClient.setex(sessionInfo.sid, 1800, sessionInfo)
    }
}