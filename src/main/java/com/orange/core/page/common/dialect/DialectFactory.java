package com.orange.core.page.common.dialect;


import com.orange.core.page.common.dialect.db.MySQLDialect;
import com.orange.core.page.common.dialect.db.OracleDialect;
import com.orange.core.page.common.dialect.db.SQLServer2005Dialect;
import com.orange.core.page.common.dialect.db.SQLServer2008Dialect;

public abstract class DialectFactory {
    public static Dialect buildDialect(Dialect.Type dialectType) {
        switch (dialectType) {
            case MYSQL:
                return new MySQLDialect();
            case ORACLE:
                return new OracleDialect();
            case SQLSERVER2005:
                return new SQLServer2005Dialect();
            case SQLSERVER2008:
                return new SQLServer2008Dialect();
            case SQLSERVER:
                return new SQLServer2005Dialect();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
