package com.orange.core.page.common.helper;

import com.orange.core.page.common.dialect.Dialect;
import com.orange.core.page.common.dialect.DialectFactory;

import java.util.HashMap;
import java.util.Map;


public abstract class DialectHelper {
	private static Map<Dialect.Type, Dialect> MAPPERS = new HashMap<Dialect.Type, Dialect>();

	public static Dialect getDialect(Dialect.Type dialectType) {
		if (MAPPERS.containsKey(dialectType)) {
			return MAPPERS.get(dialectType);
		} else {
			Dialect dialect = DialectFactory.buildDialect(dialectType);
			MAPPERS.put(dialectType, dialect);
			return dialect;
		}
	}
}
