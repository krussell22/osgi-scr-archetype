package ${package}.${rootArtifactId}.api;
import ${package}.${rootArtifactId}.api.dto.HelloException;

public interface IHello {
    /**
     * Sample interface method
     */
    public String say(String name) throws HelloException;
}
