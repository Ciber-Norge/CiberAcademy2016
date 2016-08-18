package ciber.fagdag.boot.config;

import ciber.fagdag.boot.helsesjekk.JerseyHelsesjekk;
import ciber.fagdag.boot.web.MongoDbController;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/jersey")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(JerseyHelsesjekk.class);
        register(MongoDbController.class);
        register(MultiPartFeature.class);
    }
}
