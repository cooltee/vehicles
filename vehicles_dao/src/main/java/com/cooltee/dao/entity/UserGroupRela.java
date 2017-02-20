package com.cooltee.dao.entity;

import com.cooltee.dao.orm.BaseEntity;

import javax.persistence.*;

/**
 * TODO add distributions about this class
 * Created by alittleseven on 2017/2/19.
 */
@Entity
@Table(name = "veh_user_group_rela")
public class UserGroupRela extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "group_id")
    private Long group_id;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public Long getGroup_id() {
        return group_id;
    }
}
