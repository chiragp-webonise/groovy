package myFirstApp
import com.google.inject.Inject
import myFirstApp.controller.TaskController
import org.restlet.Context
import restling.restlet.RestlingRouter
class MyAppRouter extends RestlingRouter{

    @Inject
    MyAppRouter(Context context) {
        super(context)
    }

    @Override
    void init() {
        attach("/ping", Ping)
        attach("/tasks", TaskController)
        attach("/task",TaskController)
        attach("/task/{id}",TaskController)
        attach("/task/{id}",TaskController)
    }
}
