package com.todo.service.impl

import com.google.inject.Inject
import com.todo.dao.TaskDaoI
import com.todo.db.sql.tables.pojos.Task
import com.todo.service.TaskServicesI

import java.sql.Connection

class TaskServiceImpl implements TaskServicesI {

    private final TaskDaoI taskService

    @Inject
    TaskServiceImpl(TaskDaoI taskService){
        this.taskService=taskService
    }

    @Override
    void insertTaskService(Task t) {
        taskService.insertTask(t)
    }

    @Override
    void updateTaskService(Task t) {
        taskService.updateTask(t)
    }

    @Override
    void deleteTaskService(Task t) {
        taskService.deleteTask(t)
    }

    @Override
    String readTaskService() {
        return taskService.readTask()
    }
}
