package com.cooltee.service.impl

import com.cooltee.dao.entity.User
import com.cooltee.dao.interfaces.UserDao
import com.cooltee.service.interfaces.SessionService
import com.cooltee.service.interfaces.UserService
import com.cooltee.session.SessionInfo
import com.cooltee.util.Utils
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * The Implements of User Service
 * Created by Daniel on 2017/2/11.
 */
@Service
class UserServiceImpl(
        @Autowired private val userDao: UserDao,
        @Autowired private val sessionService: SessionService
): UserService {


    private val logger = LogManager.getLogger(UserServiceImpl::class)

    override fun login(username: String, password: String): String {
        var user: User?
        try {
            val id = username.toLong()
            user = userDao.findById(id)
        } catch (e: Exception) {
            user = userDao.findByUsername(username)
        }

        if(user != null && password == user.password){
            logger.info(">> 用户${user.name}[id:${user.id}]登录成功!")
            var sessionInfo = sessionService.getSessionInfo()
            if (sessionInfo == null) {
                sessionInfo = SessionInfo(Utils.generateUUID(), null)
            }
            sessionInfo.user = user
            sessionService.save(sessionInfo)
            return "success"
        }
        return "fail"
    }

    override fun logout(sessionId: String) {
        sessionService.delete(sessionId)
    }

    override fun changePass(original: String, new: String) {
        val user = sessionService.getSessionInfo()!!.user
        if (original != user!!.password)
            throw Exception("原密码不正确！")
        user.password = new
        userDao.update(user)
    }

}