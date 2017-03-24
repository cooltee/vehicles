package com.cooltee.dao.impl;

import com.cooltee.dao.entity.OilRecord;
import com.cooltee.dao.interfaces.OilRecordDao;
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
public class OilRecordDaoImplTest extends TransSpringTestSupport {

    @Autowired
    private OilRecordDao oilRecordDao;
    private static OilRecord oilRecord;

    @BeforeClass
    public static void setup(){
        oilRecord = new OilRecord();
        oilRecord.setOil_price(123);
    }

    @Test
    public void testSave() throws Exception{
        Long id = oilRecordDao.save(oilRecord);
        oilRecord.setId(id);
        Assert.assertSame(oilRecord,oilRecordDao.findById(id));
    }

    @Test
    public void testUpdate() throws Exception{
        oilRecord.setOil_price(231);
        oilRecordDao.update(oilRecord);
        Assert.assertSame(oilRecord,oilRecordDao.findById(oilRecord.getId()));
    }

    @Ignore
    @Test
    public void testFind() throws Exception{
        OilRecord dbOilRecord = oilRecordDao.findById(1L);
        Assert.assertNotNull(dbOilRecord);
        Assert.assertSame(oilRecord,dbOilRecord);
    }

    @Test
    public void testFindAll() throws Exception{
        List<OilRecord> oilRecords = oilRecordDao.findAll();
        Assert.assertNotNull(oilRecords);
    }

    public void testDelete() throws Exception{
        oilRecordDao.delete(oilRecord);
        Assert.assertNull(oilRecordDao.findById(oilRecord.getId()));
    }


}
