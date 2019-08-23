package myFirstApp


import com.todo.modules.DataAccessModule
import com.todo.dao.TaskDaoI
import com.todo.dao.impl.TaskDaoImpl
import com.todo.service.TaskServicesI

import com.todo.service.impl.TaskServiceImpl
import groovy.transform.CompileStatic
import restling.guice.modules.RestlingApplicationModule

@CompileStatic
class AppModule extends RestlingApplicationModule{
    Class<MyAppRouter> routerClass = MyAppRouter

    @Override
    void configureCustomBindings() {
//        bind(ConnectionI).to(ConnectionServiceImpl)
        install(new DataAccessModule())
        bind(TaskDaoI).to(TaskDaoImpl)
        bind(TaskServicesI).to(TaskServiceImpl)
    }
}