package com.todo.dao

import com.todo.db.sql.tables.pojos.Task

import java.sql.Connection

interface TaskDaoI {
    void insertTask(Task t)
    void updateTask(Task t)
    void deleteTask(Task t)
    String readTask()
}