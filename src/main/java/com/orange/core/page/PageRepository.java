/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.page;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/15
 * @description
 */
public interface PageRepository {
    <M> PageModel<M> selectPaging(Condition<M> condition, Integer page, Integer pageSize);
}
