package com.todo.dao

import com.todo.db.sql.tables.pojos.Task

import java.sql.Connection

interface TaskDaoI {
    void InsertTask(Connection c, Task t)
    void UpdateTask(Connection c, Task t)
    void DeleteTask(Connection c, Task t)
    String ReadTask(Connection c)
}