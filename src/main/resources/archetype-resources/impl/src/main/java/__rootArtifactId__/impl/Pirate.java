package ${package}.${rootArtifactId}.impl;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import ${package}.${rootArtifactId}.api.IHello;
import ${package}.${rootArtifactId}.api.dto.HelloException;

@Component
@Service
public class Pirate implements IHello {

    @Activate
    public void activate(Map<String, Object> properties) {
        System.err.println("Activated Pirate");
    }

    @Override
    public String say(String name) throws HelloException {
        return String.format("Yarr %s you scurvy bum!", name);
    }

}
