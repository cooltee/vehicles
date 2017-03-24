package com.cooltee.dao.impl;

import com.cooltee.dao.entity.DriveRecord;
import com.cooltee.dao.interfaces.DriveRecordDao;
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
public class DriveRecordDaoImplTest extends TransSpringTestSupport {

    @Autowired
    private DriveRecordDao driveRecordDao;
    private static DriveRecord driveRecord;

    @BeforeClass
    public static void setup(){
        driveRecord = new DriveRecord();
        driveRecord.setDistance(11);
    }

    @Test
    public void testSave() throws Exception{
        Long id = driveRecordDao.save(driveRecord);
        driveRecord.setId(id);
        Assert.assertSame(driveRecord,driveRecordDao.findById(id));
    }

    @Test
    private void testUpdate() throws Exception{
        driveRecord.setDistance(12);
        driveRecordDao.update(driveRecord);
        Assert.assertSame(driveRecord,driveRecordDao.findById(driveRecord.getId()));
    }

    @Ignore
    @Test
    public void testFind() throws Exception{
        DriveRecord dbDriveRecord = driveRecordDao.findById(1L);
        Assert.assertNotNull(dbDriveRecord);
        Assert.assertSame(driveRecord,dbDriveRecord);
    }

    @Test
    public void testFindAll() throws Exception{
        List<DriveRecord> driveRecords = driveRecordDao.findAll();
        Assert.assertNotNull(driveRecords);
    }

    public void testDelete() throws Exception{
        driveRecordDao.delete(driveRecord);
        Assert.assertNull(driveRecordDao.findById(driveRecord.getId()));
    }


}
