/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.page;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/15
 * @description
 */
public class Condition<T> {

    private Datastore datastore;
    private Query<T> query;
    private Class clazz;

    public Condition(Datastore ds, Class<T> t) {
        this.clazz = t;
        this.datastore = ds;
        query = this.datastore.createQuery(this.clazz);
    }

    public Condition equal(String field, String value) {
        if (!StringUtils.isEmpty(value)) query.field(field).equal(value);
        return this;
    }

    public Condition notEqual(String field, String value) {
        if (!StringUtils.isEmpty(value)) query.field(field).notEqual(value);
        return this;
    }

    public Condition in(String field, Iterable<?> values) {
        query.field(field).in(values);
        return this;
    }

    public Condition notIn(String field, Iterable<?> values) {
        query.field(field).notIn(values);
        return this;
    }

    public Condition between(String field, Object left, Object right) {
        query.field(field).greaterThanOrEq(left).field(field).lessThanOrEq(right);
        return this;
    }

    public Condition lessThan(String field, Object value) {
        query.field(field).lessThan(value);
        return this;
    }

    public Condition lessThanOrEq(String field, Object value) {
        query.field(field).lessThanOrEq(value);
        return this;
    }

    public Condition greaterThan(String field, Object value) {
        query.field(field).greaterThan(value);
        return this;
    }

    public Condition greaterThanOrEq(String field, Object value) {
        query.field(field).greaterThanOrEq(value);
        return this;
    }

    public Condition like(String field, String value) {
        if (!StringUtils.isEmpty(value)) query.field(field).contains(value);
        return this;
    }

    public Condition startsWith(String field, String prefix) {
        query.field(field).startsWith(prefix);
        return this;
    }

    public Condition sort(Direction sort, String field) {
        query.order(Direction.ASC.equals(sort) ? "+" + field : "-" + field);
        return this;
    }

    public int getTotal() {
        return (int) query.countAll();
    }

    public List<T> execute(int skip, int pageSize) {
        query.retrievedFields(false, "_id").offset(skip).limit(pageSize);
        return query.asList();
    }
}
