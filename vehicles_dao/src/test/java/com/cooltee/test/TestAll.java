package com.cooltee.test;

import com.cooltee.dao.impl.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * TODO add distributions about this class
 * Created by Daniel on 2017/3/24.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		CostDaoImplTest.class,
		DriverDaoImplTest.class,
		DriverDaoImplTest.class,
		GroupDaoImplTest.class,
		GroupPermissionRelaDaoImplTest.class,
		OilRecordDaoImplTest.class,
		OilRecordDaoImplTest.class,
		PermissionDaoImplTest.class,
		RepairRecordDaoImplTest.class,
		UserDaoImplTest.class,
		UserGroupRelaDaoImplTest.class,
		VehicleDaoImplTest.class
})
public class TestAll {
}
