package ciber.fagdag.boot.response;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

public class KanalResponse {

    private KanalResponseType kanalResponseType;
    private Integer feilkode;
    private String feilmelding;

    public KanalResponse(KanalResponseType kanalResponseType) {
        this.kanalResponseType = kanalResponseType;
    }

    public KanalResponse(KanalResponseType kanalResponseType, HttpStatusCodeException httpStatusCodeException) {
        this.kanalResponseType = kanalResponseType;
        if (httpStatusCodeException != null) {
            this.feilkode = httpStatusCodeException.getStatusCode().value();
            this.feilmelding = httpStatusCodeException.getStatusCode().getReasonPhrase();
        }
    }

    public KanalResponse(KanalResponseType kanalResponseType, ResourceAccessException resourceAccessException) {
        this.kanalResponseType = kanalResponseType;
        this.feilkode = 503;
        this.feilmelding = "Service Unavailable";
    }


    public KanalResponseType getKanalResponseType() {
        return kanalResponseType;
    }

    public Integer getFeilkode() {
        return feilkode;
    }

    public String getFeilmelding() {
        return feilmelding;
    }
}

