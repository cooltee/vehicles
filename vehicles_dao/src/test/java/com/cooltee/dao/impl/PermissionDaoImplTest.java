package com.cooltee.dao.impl;

import com.cooltee.dao.entity.Permission;
import com.cooltee.dao.interfaces.PermissionDao;
import com.cooltee.test.TransSpringTestSupport;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by alittleseven on 2017/2/24.
 */
public class PermissionDaoImplTest extends TransSpringTestSupport {
    @Autowired
    private PermissionDao permissionDao;
    private static Permission permission;

    @BeforeClass
    public static void setup(){
        permission = new Permission();
        permission.setName("permission_test");
    }

    @Test
    public void testSave() throws Exception{
        Long id = permissionDao.save(permission);
        permission.setId(id);
        Assert.assertSame(permission,permissionDao.findById(id));
    }

    @Test
    public void testUpdate() throws Exception{
        permission.setName("per_test");
        permissionDao.update(permission);
        Assert.assertSame(permission,permissionDao.findById(permission.getId()));

    }

    @Ignore
    @Test
    public void testFind() throws Exception{
        Permission dbPermission = permissionDao.findById(1L);
        Assert.assertNotNull(dbPermission);
        Assert.assertSame(permission,dbPermission);
    }

    @Test
    public void testFindAll() throws Exception{
        List<Permission> permissions =permissionDao.findAll();
        Assert.assertNotNull(permissions);
    }


    public void testDelete() throws Exception{
        permissionDao.delete(permission);
        Assert.assertNull(permissionDao.findById(permission.getId()));
    }

}
