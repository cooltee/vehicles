package com.cooltee.dao.entity;

import com.cooltee.dao.orm.BaseEntity;
import org.hibernate.annotations.Cache;

import javax.persistence.*;


/**
 * TODO add distributions about this class
 * Created by alittleseven on 2017/2/19.
 */
@Entity
@Table(name = "veh_group_permission_rela")
public class GroupPermissionRela extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "group_id")
    private Long group_id;

    @Column(name = "permission_id")
    private Long permission_id;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setPermission_id(Long permission_id) {
        this.permission_id = permission_id;
    }

    public Long getPermission_id() {
        return permission_id;
    }
}
