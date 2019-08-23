package com.todo.modules

import com.google.inject.AbstractModule
import com.todo.dao.TaskDaoI
import com.todo.dao.impl.TaskDaoImpl
import com.todo.service.TaskServicesI
import com.todo.service.impl.TaskServiceImpl

import javax.naming.InitialContext
import javax.sql.DataSource
import com.todo.dataaccess.DSLContextProvider
import org.jooq.DSLContext
import groovy.transform.CompileStatic

@CompileStatic
class DataAccessModule extends AbstractModule {
    static final String DATASOURCE_JNDI = "java:comp/env/jdbc/todo-db"

    @Override
    protected void configure() {
        def dataSource = InitialContext.doLookup(DATASOURCE_JNDI) as DataSource
        bind(DataSource).toInstance(dataSource)
        bind(DSLContext).toProvider(new DSLContextProvider(dataSource, false))
    }
}
