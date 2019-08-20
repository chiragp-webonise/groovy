package myFirstApp

import com.todo.service.ConnectionI
import com.todo.service.TaskServicesI
import org.restlet.resource.Delete
import org.restlet.resource.Get
import org.restlet.resource.Post
import org.restlet.resource.Put
import org.restlet.resource.ServerResource
import com.todo.db.sql.tables.pojos.*

import com.google.inject.Inject

class TaskController extends ServerResource{

    private final ConnectionI connService
    private final TaskServicesI taskServices

    @Inject
    TaskController(ConnectionI connService, TaskServicesI taskServices){
        this.connService=connService
        this.taskServices=taskServices
    }

    @Post
    void doPost(Task t) {

        println("HERE"+t.description)
        taskServices.insertTaskService(connService.getConnection(),t)
    }

    @Put
    void doPut(Task t){
        t.id=(getAttribute("id") as int)
        taskServices.updateTaskService(connService.getConnection(),t)
    }

    @Get
    String doGet() {
        return taskServices.readTaskService(connService.getConnection())
    }

    @Delete
    void doDelete(){
        Task t=new Task()
        t.setId((getAttribute("id") as int))
        taskServices.deleteTaskService(connService.getConnection(),t)
    }
}
