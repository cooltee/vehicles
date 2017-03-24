package com.cooltee.dao.impl;

import com.cooltee.dao.entity.Driver;
import com.cooltee.dao.interfaces.DriverDao;
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
public class DriverDaoImplTest extends TransSpringTestSupport {

    @Autowired
    private DriverDao driverDao;
    private static Driver driver;

    @BeforeClass
    public static void setup(){
        driver = new Driver();
        driver.setName("driverTest");
    }

    @Test
    public void testASave() throws Exception{
        Long id = driverDao.save(driver);
        driver.setId(id);
        Assert.assertSame(driver,driverDao.findById(id));
    }

    @Test
    public void testUpdate() throws Exception{
        driver.setName("driverTest2");
        driverDao.update(driver);
        Assert.assertSame(driver,driverDao.findById(driver.getId()));
    }

    @Ignore
    @Test
    public void testFind() throws Exception{
        Driver dbDriver = driverDao.findById(1L);
        Assert.assertNotNull(dbDriver);
        Assert.assertSame(driver,dbDriver);
    }

    @Test
    public void testFindAll() throws Exception{
        List<Driver> drivers = driverDao.findAll();
        Assert.assertNotNull(drivers);
    }

    @Test
    public void testZDelete() throws Exception{
        driverDao.delete(driver);
        Assert.assertNull(driverDao.findById(driver.getId()));
    }



}
