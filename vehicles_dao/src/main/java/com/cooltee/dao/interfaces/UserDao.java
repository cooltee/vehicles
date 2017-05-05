package com.cooltee.dao.interfaces;

import com.cooltee.dao.entity.User;
import com.cooltee.dao.orm.BaseDao;
import org.jetbrains.annotations.NotNull;

/**
 * dao functions of user define interface
 * Created by Daniel on 2017/2/12.
 */
public interface UserDao extends BaseDao<User> {

	User findByUsername(String username);

}
