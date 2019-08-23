package com.todo.dao.impl

import com.todo.dao.TaskDaoI
import org.jooq.impl.DSL
import java.sql.Connection
import com.todo.db.sql.tables.pojos.Task;
import org.jooq.DSLContext
import com.google.inject.Inject
import groovy.transform.CompileStatic


class TaskDaoImpl implements TaskDaoI {
    final DSLContext dslContext

    @Inject
    TaskDaoImpl(DSLContext dslContext) {
        this.dslContext = dslContext
    }

    @Override
    void insertTask(Task t) {
        dslContext.newRecord(com.todo.db.sql.tables.Task.TASK,t).store()
    }

    @Override
    void updateTask(Task t) {
        def task=com.todo.db.sql.tables.Task.TASK
        dslContext.update(task)
                .set(task.DESCRIPTION,t.description)
                .where(task.ID.eq(t.id))
                .execute()
    }

    @Override
    void deleteTask(Task t) {
        def task=com.todo.db.sql.tables.Task.TASK
        dslContext.delete(task).where(task.ID.eq(t.id)).execute()
    }

    @Override
    String readTask() {
         return dslContext.selectFrom("task").fetch().format()
    }
}
