package com.todo.service

import com.todo.db.sql.tables.pojos.Task

import java.sql.Connection

interface TaskServicesI {
    void insertTaskService(Connection c,Task t)
    void updateTaskService(Connection c,Task t)
    void deleteTaskService(Connection c,Task t)
    String readTaskService(Connection c)
}