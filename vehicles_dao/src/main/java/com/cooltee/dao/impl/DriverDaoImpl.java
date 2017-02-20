package com.cooltee.dao.impl;

import com.cooltee.dao.entity.Driver;
import com.cooltee.dao.interfaces.DriverDao;
import com.cooltee.dao.orm.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * dao of driver
 * Created by alittleseven on 2017/2/20.
 */

@Repository
public class DriverDaoImpl extends BaseDaoImpl<Driver> implements DriverDao {
}
