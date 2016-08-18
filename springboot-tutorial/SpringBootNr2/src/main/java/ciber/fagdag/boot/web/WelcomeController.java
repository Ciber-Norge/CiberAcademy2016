package ciber.fagdag.boot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @RequestMapping(value = "/", produces = "application/json") // Spring MVC
    public String velkommenTilFagdag() {
        return "Velkommen til den andre Boot : Spring Boot";
    }
}
