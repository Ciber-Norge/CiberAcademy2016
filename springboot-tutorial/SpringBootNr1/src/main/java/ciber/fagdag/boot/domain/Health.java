package ciber.fagdag.boot.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "ciber.fagdag.boot.health")
public class Health {

    private String status;

    protected Health() {
    }

    public Health(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
