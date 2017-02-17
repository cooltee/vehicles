package com.cooltee.service.impl;

import com.cooltee.dao.interfaces.UserDao;
import com.cooltee.service.interfaces.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * implements Interface of UserSersive
 * Created by Daniel on 2017/2/11.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public String getUserName(Long id) {
        String username = userDao.findById(id).getName();
        logger.debug("username is " + username);
        return username;
    }

}
