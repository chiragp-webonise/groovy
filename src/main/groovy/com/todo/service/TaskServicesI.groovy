package com.todo.service

import com.todo.db.sql.tables.pojos.Task

import java.sql.Connection

interface TaskServicesI {
    void insertTaskService(Task t)
    void updateTaskService(Task t)
    void deleteTaskService(Task t)
    String readTaskService()
}