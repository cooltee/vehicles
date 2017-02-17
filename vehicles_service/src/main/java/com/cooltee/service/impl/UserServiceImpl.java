package com.cooltee.service.impl;

import com.cooltee.dao.interfaces.UserDao;
import com.cooltee.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * implements Interface of UserSersive
 * Created by Daniel on 2017/2/11.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String getUserName(Long id) {
        return userDao.findById(id).getName();
    }

}
