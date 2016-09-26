package ${package}.${rootArtifactId}.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.log.LogService;

import ${package}.${rootArtifactId}.api.IHello;
import ${package}.${rootArtifactId}.api.dto.HelloException;

@Component
@Service(value=HelloHttp.class)
@Path("hello")
public class HelloHttp {

    @Reference
    private IHello hello;
    
    @Reference
    LogService logger;
    
    @Activate
    public void activator() {
        logger.log(LogService.LOG_INFO, "** HelloHttp Starting up **");
    }
    
    /**
     * Shows running with a query string
     * @param name
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HelloObj hello(@QueryParam("Name") String name) throws HelloException {
        return new HelloObj(hello.say(name));
    }
    
    /**
     * Shows running with a path element
     * @param name
     * @return
     */
    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloPath(@PathParam("name") String name) throws HelloException {
        return hello.say(name);
    }
    
    /**
     * Class to show off json
     * @author shawn
     *
     */
    public class HelloObj {
        public String hello;
        public HelloObj(String hello) {
            this.hello = hello;
        }
    }
}
