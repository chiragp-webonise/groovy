package com.todo.service.impl

import com.todo.service.ConnectionI
import groovy.sql.Sql

import java.sql.Connection

class ConnectionServiceImpl implements ConnectionI {
    @Override
    Connection getConnection() {
        Class.forName("com.mysql.jdbc.Driver")
        def sql = Sql.newInstance(
                'jdbc:mysql://localhost:3306/todo?createDatabaseIfNotExist=true&&useUnicode=true&characterEncoding=utf8',
                'root', 'root', 'com.mysql.jdbc.Driver')
        return sql.connection
    }
}
