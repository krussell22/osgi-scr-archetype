package ${package}.${rootArtifactId}.impl;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

import ${package}.${rootArtifactId}.api.IHello;
import ${package}.${rootArtifactId}.api.dto.HelloException;

@Component(metatype = true, label = "English Hello-world")
@Service
public class English implements IHello {
    private final static String DEFAULT_GREETING = "Hello";

    @Property(value = DEFAULT_GREETING, label = "Greeting", description = "The greeting to use")
    private final static String PROP_GREETING    = "greeting";

    private String              greeting;

    @Override
    public String say(String name) throws HelloException {
        return String.format("%s %s", greeting, name);
    }

    @Activate
    public void activate(Map<String, Object> properties) {
        System.err.println("Activated English");
        greeting = properties.get(PROP_GREETING).toString();
    }

    @Modified
    public void modified(Map<String, Object> properties) {
        greeting = properties.get(PROP_GREETING).toString();
        System.err.println("Greeting was modified to " + greeting);
    }

}
