package com.cooltee.dao.impl;

import com.cooltee.dao.entity.GroupPermissionRela;
import com.cooltee.dao.interfaces.GroupPermissionRelaDao;
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
public class GroupPermissionRelaDaoImplTest {

    @Autowired
    private GroupPermissionRelaDao groupPermissionRelaDao;
    private static GroupPermissionRela groupPermissionRela;

    @BeforeClass
    public static void setup() {
        groupPermissionRela = new GroupPermissionRela();
        groupPermissionRela.setPermission_id(1L);
    }

    @Test
    public void testSave() throws Exception{
        Long id = groupPermissionRelaDao.save(groupPermissionRela);
        groupPermissionRela.setId(id);
        Assert.assertSame(groupPermissionRela,groupPermissionRelaDao.findById(id));
    }

    @Test
    public void testUpdate() throws Exception{
        groupPermissionRela.setGroup_id(1L);
        groupPermissionRelaDao.update(groupPermissionRela);
        Assert.assertSame(groupPermissionRela,groupPermissionRelaDao.findById(groupPermissionRela.getId()));

    }

    @Ignore
    @Test
    public void testFind() throws Exception{
        GroupPermissionRela dbGroupPermissionRela = groupPermissionRelaDao.findById(1L);
        Assert.assertNotNull(dbGroupPermissionRela);
        Assert.assertSame(groupPermissionRela,dbGroupPermissionRela);
    }

    @Test
    public void testFindAll() throws Exception{
        List<GroupPermissionRela> groupPermissionRelas = groupPermissionRelaDao.findAll();
        Assert.assertNotNull(groupPermissionRelas);
    }

    public void testDelete() throws Exception{
        groupPermissionRelaDao.delete(groupPermissionRela);
        Assert.assertNull(groupPermissionRelaDao.findById(groupPermissionRela.getId()));
    }


}

