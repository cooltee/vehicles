package com.cooltee.dao.orm;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * All entity should extends The BaseEntity
 * Created by Daniel on 2017/2/12.
 */
public class BaseEntity {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
