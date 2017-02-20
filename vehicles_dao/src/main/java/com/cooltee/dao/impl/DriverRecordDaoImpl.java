package com.cooltee.dao.impl;

import com.cooltee.dao.entity.DriveRecord;
import com.cooltee.dao.interfaces.DriveRecordDao;
import com.cooltee.dao.orm.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * dao of driverecord
 * Created by alittleseven on 2017/2/20.
 */
@Repository
public class DriverRecordDaoImpl extends BaseDaoImpl<DriveRecord> implements DriveRecordDao {
}
