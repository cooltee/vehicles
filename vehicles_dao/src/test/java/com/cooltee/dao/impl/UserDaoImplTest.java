package com.cooltee.dao.impl;

import com.cooltee.dao.entity.User;
import com.cooltee.dao.interfaces.UserDao;
import com.cooltee.test.NoTransSpringTestSupport;
import org.hibernate.FlushMode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.FlushModeType;
import java.util.List;

/**
 * Test UserDao implements
 * Created by Daniel on 2017/2/14.
 */
@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoImplTest extends NoTransSpringTestSupport {

    @Autowired
    private UserDao userDao;
    private User user;

    {
        user = new User();
        user.setName("spring");
    }

    //@Before
    public void setup() {
        ((UserDaoImpl)userDao).getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushModeType.AUTO);
    }

    @Test
    public void testSave() throws Exception {
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

    @Test
    public void testFind() throws Exception {
        User dbUser = userDao.findById(user.getId());
        Assert.assertNotNull(dbUser);
        Assert.assertSame(user, dbUser);
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> users = userDao.findAll();
        Assert.assertNotNull(users);
    }

    @Test
    public void testDelete() throws Exception {
        userDao.delete(user);
        Assert.assertNull(userDao.findById(user.getId()));
    }
}