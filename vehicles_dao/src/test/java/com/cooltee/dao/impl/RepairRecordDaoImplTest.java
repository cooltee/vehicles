package com.cooltee.dao.impl;


import com.cooltee.dao.entity.RepairRecord;
import com.cooltee.dao.interfaces.RepairRecordDao;
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
public class RepairRecordDaoImplTest {

    @Autowired
    private RepairRecordDao repairRecordDao;
    private static RepairRecord repairRecord;

    @BeforeClass
    public static void setup(){
        repairRecord = new RepairRecord();
        repairRecord.setCost_id(1L);
        //setDescription
    }

    @Test
    public void testSave() throws Exception{
        Long id = repairRecordDao.save(repairRecord);
        repairRecord.setId(id);
        Assert.assertSame(repairRecord,repairRecordDao.findById(id));
    }

    @Test
    public void testUpdate() throws Exception{
        repairRecord.setCost_id(1L);
        repairRecordDao.update(repairRecord);
        Assert.assertSame(repairRecord,repairRecordDao.findById(repairRecord.getId()));
    }

    @Ignore
    @Test
    public void testFind() throws Exception{
        RepairRecord dbRepairRecord = repairRecordDao.findById(1L);
        Assert.assertNotNull(dbRepairRecord);
        Assert.assertSame(repairRecord,dbRepairRecord);
    }
    @Test
    public void testFindAll() throws Exception{
        List<RepairRecord> repairRecords =repairRecordDao.findAll();
        Assert.assertNotNull(repairRecords);
    }

    public void testDelete() throws Exception{
        repairRecordDao.delete(repairRecord);
        Assert.assertNull(repairRecordDao.findById(repairRecord.getId()));
    }



}
