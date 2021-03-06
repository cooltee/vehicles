package com.cooltee.dao.impl;

import com.cooltee.dao.entity.Permission;
import com.cooltee.dao.interfaces.PermissionDao;
import com.cooltee.dao.orm.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * dao of permission
 * Created by alittleseven on 2017/2/20.
 */
@Repository
public class PermissionDaoImpl extends BaseDaoImpl<Permission> implements PermissionDao {
}
