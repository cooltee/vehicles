package com.cooltee.service.interfaces

/**
 * The Interface of UserService
 * Created by Daniel on 2017/2/11.
 */
interface UserService {

    fun getUserInfo(): Map<String, String>

    fun login(username: String, password: String): String
}
