package myFirstApp

import org.restlet.resource.Get
import org.restlet.resource.ServerResource

class Ping extends ServerResource {

    @Get
    String doGet() {
        logger.info("Excuting doGet() in ${this.class}")
        return "Hello, World!"
    }
}