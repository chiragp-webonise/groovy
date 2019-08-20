package com.todo.service

import java.sql.Connection

interface ConnectionI {
    Connection getConnection()
}