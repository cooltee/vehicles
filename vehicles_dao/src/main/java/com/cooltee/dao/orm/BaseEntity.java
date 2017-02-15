package com.cooltee.dao.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * All entity should extends The BaseEntity
 * Created by Daniel on 2017/2/12.
 */
public abstract class BaseEntity {

    protected abstract void setId(Long id);

    protected abstract Long getId();
}
