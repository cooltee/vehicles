package com.cooltee.service.interfaces

import com.cooltee.dao.entity.User

/**
 * The Interface of User Service
 * Created by Daniel on 2017/2/11.
 */
interface UserService {

    fun login(username: String, password: String): String
    fun logout(sessionId: String)
    fun changePass(original: String, new: String)

}
