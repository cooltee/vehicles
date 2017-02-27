package com.cooltee.dao.impl;

import com.cooltee.dao.entity.OilRecord;
import com.cooltee.dao.entity.OtherRecord;
import com.cooltee.dao.interfaces.OtherRecordDao;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alittleseven on 2017/2/24.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class OtherRecordDaoImplTest {

    @Autowired
    private OtherRecordDao otherRecordDao;
    private static OtherRecord otherRecord;

    @BeforeClass
    public static void setup(){
        otherRecord = new OtherRecord();
        otherRecord.setDescription("other_test");
    }

    @Test
    public void testSave() throws Exception{
        Long id = otherRecordDao.save(otherRecord);
        otherRecord.setId(id);
        Assert.assertSame(otherRecord,otherRecordDao.findById(id));
    }

    @Test
    public void testUpdate() throws Exception{
        otherRecord.setDescription("other_re_test");
        otherRecordDao.update(otherRecord);
        Assert.assertSame(otherRecord,otherRecordDao.findById(otherRecord.getId()));
    }

    @Ignore
    @Test
    public void testFind() throws Exception{
        OtherRecord dbOtherRecord = otherRecordDao.findById(1L);
        Assert.assertNotNull(dbOtherRecord);
        Assert.assertSame(otherRecord,dbOtherRecord);
    }

    @Test
    public void testFindAll() throws Exception{
        List<OtherRecord> otherRecords = otherRecordDao.findAll();
        Assert.assertNotNull(otherRecords);
    }

    public void testDelete() throws Exception{
        otherRecordDao.delete(otherRecord);
        Assert.assertNull(otherRecordDao.findById(otherRecord.getId()));

    }
}
