package ${package}.${rootArtifactId}.command;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import ${package}.${rootArtifactId}.api.IHello;
import ${package}.${rootArtifactId}.api.dto.HelloException;

@Component
@Service(HelloCommand.class)
@Properties({ @Property(name = "osgi.command.scope", value = "hello"),
        @Property(name = "osgi.command.function", value = { "sayhi" }) })
public class HelloCommand {

    @Reference
    private IHello hello;

    public void sayhi(String name) throws HelloException {
        if (null != hello) {
            System.out.println(hello.say(name));
        } else {
            System.err.println("No IHelloWorld service");
        }
    }
}
