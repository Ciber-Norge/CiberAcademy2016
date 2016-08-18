package ciber.fagdag.boot.helsesjekk;


import ciber.fagdag.boot.domain.Health;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringHelsesjekk {

    @RequestMapping(value = "/spring/health", produces = "application/json") // Spring MVC
    public Health springMvc() {
        return new Health("Spring MVC: Up and Running!");
    }


}
