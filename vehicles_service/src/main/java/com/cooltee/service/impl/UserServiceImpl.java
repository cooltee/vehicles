package com.cooltee.service.impl;

import com.cooltee.dao.entity.User;
import com.cooltee.dao.interfaces.UserDao;
import com.cooltee.service.interfaces.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, String> getUsers() {
        List<User> users = userDao.findAll();
        logger.debug("users list is " + users);
        Map<String, String> userMap = new HashMap<>();
        User user = users.get(0);
        userMap.put("id", user.getId().toString());
        userMap.put("name", user.getName());
        return userMap;
    }

}
