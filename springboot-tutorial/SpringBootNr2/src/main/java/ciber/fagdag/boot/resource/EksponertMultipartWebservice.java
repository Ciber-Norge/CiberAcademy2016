package ciber.fagdag.boot.resource;

import ciber.fagdag.boot.domain.Melding;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/api")
public class EksponertMultipartWebservice {

    private static final Logger LOGGER = LoggerFactory.getLogger(EksponertMultipartWebservice.class);

    @POST
    @Path("/send/file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response send(@FormDataParam("springBootMelding") Melding melding,
                         FormDataMultiPart multiPart) {

        System.out.println("Vi har mottatt en fil av " +
                "typen 'MULTIPART'..bare dummydata selvsagt :-)");
        return Response.ok().build();

    }

}
