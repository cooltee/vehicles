package com.cooltee.service.interfaces

/**
 * The Interface of User Service
 * Created by Daniel on 2017/2/11.
 */
interface UserService {

    fun login(username: String, password: String): String
}
