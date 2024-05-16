package com.example;

import org.hibernate.resource.jdbc.spi.StatementInspector;

public class CustomStatementInspector implements StatementInspector {
    @Override
    public String inspect(String sql) {
        System.out.println("MySql upit" + sql);
        return sql;
    }
}
