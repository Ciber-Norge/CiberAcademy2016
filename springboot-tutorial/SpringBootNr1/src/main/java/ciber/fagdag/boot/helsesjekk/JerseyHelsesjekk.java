package ciber.fagdag.boot.helsesjekk;

import ciber.fagdag.boot.domain.Health;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Component
@Path("/health")
public class JerseyHelsesjekk {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Health health() {
        return new Health("Jersey: Up and Running!");
    }

}
