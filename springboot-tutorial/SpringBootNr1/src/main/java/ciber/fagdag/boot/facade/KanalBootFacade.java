package ciber.fagdag.boot.facade;

import ciber.fagdag.boot.domain.multipart.Melding;
import ciber.fagdag.boot.response.KanalResponse;
import ciber.fagdag.boot.response.KanalResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class KanalBootFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(KanalBootFacade.class);

    @Value("${kanal.boot.ny_melding.url}")
    private String urlKanalSDP;

    private RestTemplate restTemplate = new RestTemplate();

    public KanalResponse send(Melding melding) {
        sendTilKanalBoot(melding);
        return new KanalResponse(KanalResponseType.SENDING_OK);
    }

    private void sendTilKanalBoot(Melding melding) {

        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("springBootMelding", melding);
        parts.add(null, null);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(parts, requestHeaders);

        ResponseEntity<String> feedback = restTemplate.exchange(urlKanalSDP, HttpMethod.POST, requestEntity, String.class);
        System.out.println("Feedback is : " + feedback);
    }

}
