/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/15
 * @description
 */
public class DefaultPageRepository implements PageRepository {

    public DefaultPageRepository() {
        super();
    }

    @Override
    public <M> PageModel<M> selectPaging(Condition<M> condition, Integer page, Integer pageSize) {
        PageModel<M> result = new PageModel<>();
        result.setTotal(condition.getTotal());
        result.setPage(page);
        result.setPageSize(pageSize);
        List<M> rows = condition.execute(result.getSkip(), result.getPageSize());
        result.setRows(rows == null ? new ArrayList<>() : rows);
        result.setTotalPages(result.getTotalPages());
        return result;
    }
}
