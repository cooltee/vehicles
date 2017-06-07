package com.cooltee.session

import com.cooltee.dao.entity.User
import java.io.Serializable

/**
 * data class of Session info
 * Created by Daniel on 2017/5/17.
 */
data class SessionInfo(val sid:String, var user: User?, var permission: Int?) : Serializable