package com.cooltee.dao.impl;

import com.cooltee.dao.entity.User;
import com.cooltee.dao.interfaces.UserDao;
import com.cooltee.dao.orm.BaseDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * dao of user
 * Created by Daniel on 2017/2/12.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	private static Logger logger = LogManager.getLogger(UserDaoImpl.class);

	@Override
	public User findByUsername(String username) {
		String hql = "FROM User u WHERE u.username = :username";
		User user;
		try {
			user =  (User) getSession().createQuery(hql).setParameter("username", username).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No user whit username -> {} ", username);
			logger.debug(e.getMessage(), e.getCause());
			user = null;
		}
		return user;
	}
}
