package com.cooltee.dao.impl;

import com.cooltee.dao.entity.UserGroupRela;
import com.cooltee.dao.interfaces.UserGroupRelaDao;
import com.cooltee.test.TransSpringTestSupport;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alittleseven on 2017/2/23.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserGroupRelaDaoImplTest extends TransSpringTestSupport {

    @Autowired
    private UserGroupRelaDao userGroupRelaDao;
    private  static UserGroupRela userGroupRela;

    @BeforeClass
    public static void setup(){
        userGroupRela =new UserGroupRela();
        //Long id
        userGroupRela.setGroup_id(1L);
    }

    @Test
    public void testSave() throws Exception{
        Long id = userGroupRelaDao.save(userGroupRela);
        userGroupRela.setId(id);
        Assert.assertSame(userGroupRela,userGroupRelaDao.findById(id));
    }

    @Test
    public void testUpdate() throws Exception{
        //Long id
        userGroupRela.setGroup_id(userGroupRela.getGroup_id());
        userGroupRelaDao.update(userGroupRela);
        Assert.assertSame(userGroupRela,userGroupRelaDao.findById(userGroupRela.getId()));
    }

    @Ignore
    @Test
    public void testFind() throws Exception{
        UserGroupRela dbUserGroupRela = userGroupRelaDao.findById(1L);
        Assert.assertNotNull(dbUserGroupRela);
        Assert.assertSame(userGroupRela,dbUserGroupRela);
    }

    @Test
    public void testFindAll() throws Exception{
        List<UserGroupRela> userGroupRelas = userGroupRelaDao.findAll();
        Assert.assertNotNull(userGroupRelas);
    }
}
