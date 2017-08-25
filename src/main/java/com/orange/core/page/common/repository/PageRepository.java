package com.orange.core.page.common.repository;

import com.orange.core.page.common.model.PageParam;
import com.orange.core.page.common.model.PageResult;

import java.util.List;


public interface PageRepository {
	<E> PageResult<E> selectPaging(Class mapperClass, String sqlId, PageParam parameter);

	<E> PageResult<E> selectPaging(String statement, PageParam parameter);

	<E> PageResult<E> selectPaging(String statement, Object parameter, int page, int count);

	<E> List<E> selectRows(Class mapperClass, String sqlId, PageParam parameter);
}
