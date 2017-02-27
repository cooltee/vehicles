package com.cooltee.dao.impl;

import com.cooltee.dao.entity.Cost;
import com.cooltee.dao.interfaces.CostDao;
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
public class CostDaoImplTest {

    @Autowired
    private CostDao costDao;
    private static Cost cost;

    @BeforeClass
    public static void setup(){
        cost = new Cost();
        cost.setAmount("1233");

    }

    @Test
    public void testSave() throws Exception{
        Long id = costDao.save(cost);
        cost.setId(id);
        Assert.assertSame(cost,costDao.findById(id));
    }

    @Test
    public void testUpdate() throws Exception{
        cost.setAmount("243425");
        costDao.update(cost);
        Assert.assertSame(cost,costDao.findById(cost.getId()));
    }

    @Ignore
    @Test
    public void testFind() throws Exception{
        Cost dbCost = costDao.findById(1L);
        Assert.assertNotNull(dbCost);
        Assert.assertSame(cost,dbCost);
    }
    @Test
    public void testFindAll() throws Exception{
        List<Cost> costs =costDao.findAll();
        Assert.assertNotNull(costs);
    }

    @Test
    public void testDelete() throws Exception{
        costDao.delete(cost);
        Assert.assertNull(costDao.findById(cost.getId()));
    }


}
