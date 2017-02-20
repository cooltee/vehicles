package com.cooltee.dao.impl;

import com.cooltee.dao.entity.Group;
import com.cooltee.dao.interfaces.GroupDao;
import com.cooltee.dao.orm.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * dao of group
 * Created by alittleseven on 2017/2/20.
 */

@Repository
public class GroupDaoImpl extends BaseDaoImpl<Group> implements GroupDao{
}
