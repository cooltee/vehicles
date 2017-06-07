package com.cooltee.dao.impl;

import com.cooltee.dao.entity.User;
import com.cooltee.dao.interfaces.UserDao;
import com.cooltee.test.TransSpringTestSupport;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Test UserDao implements
 * Created by Daniel on 2017/2/14.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserDaoImplTest extends TransSpringTestSupport {

    @Autowired
    private UserDao userDao;
    private static User user;


    @BeforeClass
    public static void setup() {
        user = new User("daniel","admin", User.DEFAULT_PASSWORD, "test", User.DEFAULT_STATE);
        user.setName("spring");
    }

    @Test
    public void testASave() throws Exception {
        Long id = userDao.save(user);
        user.setId(id);
        Assert.assertSame(user, userDao.findById(id));
    }

    @Test
    public void testUpdate() throws Exception {

        user.setName("test");
        userDao.update(user);
        Assert.assertSame(user, userDao.findById(user.getId()));
    }


    @Ignore
    @Test
    public void testFind() throws Exception {
        //need database have a record to find
        User dbUser = userDao.findById(1L);
        Assert.assertNotNull(dbUser);
        Assert.assertSame(user, dbUser);
    }

    @Test
    public void testDFindAll() throws Exception {
        List<User> users = userDao.findAll();
        Assert.assertNotNull(users);
    }

    @Test
    public void testEDelete() throws Exception {
        userDao.delete(user);
        Assert.assertNull(userDao.findById(user.getId()));
    }
}