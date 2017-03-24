package com.cooltee.dao.impl;

import com.cooltee.dao.entity.Group;
import com.cooltee.dao.interfaces.GroupDao;
import com.cooltee.test.TransSpringTestSupport;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alittleseven on 2017/2/27.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class GroupDaoImplTest extends TransSpringTestSupport {

    @Autowired
    private GroupDao groupDao;
    private static Group group;

    @BeforeClass
    public static void setup(){
        group =new Group();
        group.setName("groupTest");
    }

    @Test
    public void testSave() throws Exception{
        Long id = groupDao.save(group);
        group.setId(id);
        Assert.assertSame(group,groupDao.findById(id));
    }

    @Test
    public void testUpadate() throws Exception{
        group.setName("groupTest");
        groupDao.update(group);
        Assert.assertSame(group,groupDao.findById(group.getId()));
    }

    @Ignore
    @Test
    public void testFind() throws Exception{
        Group dbGroup = groupDao.findById(1L);
        Assert.assertNotNull(dbGroup);
        Assert.assertSame(group,dbGroup);
    }

    @Test
    public void testFindAll() throws Exception{
        List<Group> groups = groupDao.findAll();
        Assert.assertNotNull(groups);
    }

    public void testDelete() throws Exception{
        groupDao.delete(group);
        Assert.assertNull(groupDao.findById(group.getId()));
    }

}
