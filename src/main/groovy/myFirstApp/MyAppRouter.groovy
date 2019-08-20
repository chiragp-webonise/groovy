package myFirstApp
import com.google.inject.Inject
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
        attach("/tasks/view",TaskController)
        attach("/task/create",TaskController)
        attach("/task/edit/{id}",TaskController)
        attach("/task/remove/{id}",TaskController)
    }
}
