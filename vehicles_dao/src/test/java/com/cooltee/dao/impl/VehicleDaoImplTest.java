package com.cooltee.dao.impl;

import com.cooltee.dao.entity.Vehicle;
import com.cooltee.dao.interfaces.VehicleDao;
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
public class VehicleDaoImplTest  {

    @Autowired
    private VehicleDao vehicleDao;
    private static Vehicle vehicle;

    @BeforeClass
    public static void setup(){
        vehicle = new Vehicle();
        vehicle.setModels("bit");

    }

    @Test
    public void testSave() throws Exception{
        Long id = vehicleDao.save(vehicle);
        vehicle.setId(id);
        Assert.assertSame(vehicle,vehicleDao.findById(id));
    }

    @Test
    public void testUpdate() throws Exception{
        vehicle.setModels("vehicleTest");
        vehicleDao.update(vehicle);
        Assert.assertSame(vehicle,vehicleDao.findById(vehicle.getId()));
    }

    @Ignore
    @Test
    public void testFind() throws Exception{
        Vehicle dbVehicle = vehicleDao.findById(1L);
        Assert.assertNotNull(dbVehicle);
        Assert.assertSame(vehicle,dbVehicle);
    }


    @Test
    public void testFindAll() throws Exception{
        List<Vehicle> vehicles = vehicleDao.findAll();
        Assert.assertNull(vehicleDao.findById(vehicle.getId()));
    }

}
