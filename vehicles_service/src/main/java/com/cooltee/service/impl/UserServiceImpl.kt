package com.cooltee.service.impl

import com.cooltee.dao.entity.User
import com.cooltee.dao.interfaces.UserDao
import com.cooltee.service.interfaces.UserService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(@Autowired private val userDao: UserDao): UserService {

    private val logger = LogManager.getLogger(UserServiceImpl::class)

    override fun getUserInfo(): Map<String, String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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
            return "success"
        }
        return "fail"
    }
}