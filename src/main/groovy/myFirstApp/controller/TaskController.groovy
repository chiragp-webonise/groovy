package myFirstApp.controller


import com.todo.service.TaskServicesI
import org.restlet.resource.Delete
import org.restlet.resource.Get
import org.restlet.resource.Post
import org.restlet.resource.Put
import org.restlet.resource.ServerResource
import com.todo.db.sql.tables.pojos.*

import com.google.inject.Inject

import groovy.transform.CompileStatic

@CompileStatic
class TaskController extends ServerResource{

    private final TaskServicesI taskServices

    @Inject
    TaskController(TaskServicesI taskServices){
        this.taskServices=taskServices
    }

    @Post
    void doPost(Task t) {
        taskServices.insertTaskService(t)
    }

    @Put
    void doPut(Task t){
        t.id=(getAttribute("id") as int)
        taskServices.updateTaskService(t)
    }

    @Get
    String doGet() {
        return taskServices.readTaskService()
    }

    @Delete
    void doDelete(){
        Task t=new Task()
        t.setId((getAttribute("id") as int))
        taskServices.deleteTaskService(t)
    }
}
