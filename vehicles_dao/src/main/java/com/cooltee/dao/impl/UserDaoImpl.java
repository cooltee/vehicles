package com.cooltee.dao.impl;

import com.cooltee.dao.entity.User;
import com.cooltee.dao.interfaces.UserDao;
import com.cooltee.dao.orm.BaseDaoImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * dao of user
 * Created by Daniel on 2017/2/12.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findByUsername(String username) {
		String hql = "FROM User u WHERE u.username = :username";
		return (User) getSession().createQuery(hql).setParameter("username", username).getSingleResult();
	}
}
