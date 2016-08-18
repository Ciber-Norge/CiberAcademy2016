package ciber.fagdag.boot.web;

import ciber.fagdag.boot.domain.multipart.Melding;
import ciber.fagdag.boot.facade.KanalBootFacade;
import ciber.fagdag.boot.response.KanalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JerseyMultipartController {

    @Autowired
    KanalBootFacade kanalBootFacade;

    @RequestMapping(value = "/send", produces = "application/json") // Spring MVC
    public String send() {
        KanalResponse status = kanalBootFacade.send(new Melding());
        return "vi har sendt data  til den andre Boot " +
                "applikasjonen og resultatet ble : " + status.getKanalResponseType().toString();
    }
}
