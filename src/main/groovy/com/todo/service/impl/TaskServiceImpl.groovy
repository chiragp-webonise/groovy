package com.todo.service.impl

import com.google.inject.Inject
import com.todo.dao.TaskDaoI
import com.todo.db.sql.tables.pojos.Task
import com.todo.service.TaskServicesI

import java.sql.Connection

class TaskServiceImpl implements TaskServicesI {

    private final TaskDaoI TaskService

    @Inject
    TaskServiceImpl(TaskDaoI TaskService){
        this.TaskService=TaskService
    }

    @Override
    void insertTaskService(Connection c, Task t) {
        TaskService.InsertTask(c,t)
    }

    @Override
    void updateTaskService(Connection c, Task t) {
        TaskService.UpdateTask(c,t)
    }

    @Override
    void deleteTaskService(Connection c, Task t) {
        TaskService.DeleteTask(c,t)
    }

    @Override
    String readTaskService(Connection c) {
        return TaskService.ReadTask(c)
    }
}
