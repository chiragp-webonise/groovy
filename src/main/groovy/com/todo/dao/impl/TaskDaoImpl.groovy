package com.todo.dao.impl

import com.todo.dao.TaskDaoI
import org.jooq.impl.DSL
import java.sql.Connection
import com.todo.db.sql.tables.pojos.Task;

class TaskDaoImpl implements TaskDaoI {

    @Override
    void InsertTask(Connection c, Task t) {
        DSL.using(c).newRecord(com.todo.db.sql.tables.Task.TASK,t).store()
    }

    @Override
    void UpdateTask(Connection c, Task t) {
        def task=com.todo.db.sql.tables.Task.TASK
        DSL.using(c).update(task)
                .set(task.DESCRIPTION,t.description)
                .where(task.ID.eq(t.id))
                .execute()
    }

    @Override
    void DeleteTask(Connection c, Task t) {
        def task=com.todo.db.sql.tables.Task.TASK
        DSL.using(c).delete(task).where(task.ID.eq(t.id)).execute()
    }

    @Override
    String ReadTask(Connection c) {
         return DSL.using(c).selectFrom("task").fetch().format()
    }
}
