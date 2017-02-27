package com.cooltee.service.impl;

import com.cooltee.service.interfaces.UserService;
import com.cooltee.test.TransSpringTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * test UserDao
 * Created by Daniel on 2017/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest extends TransSpringTestSupport{

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserName()  {
        Map<String, String> result = userService.getUsers();
        assertNotNull(result);
        System.out.print(result.size());
    }
}