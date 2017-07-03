package rest;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class SpringWebRestClientTest {

    private static final String URL = "http://localhost:1990";
    private static final String CONFLUENCE_API_REST_PATTH = "/confluence/rest/livingdoc/1.0/command";
    private static final String CONFLUENCE_URL_API_REST = URL + CONFLUENCE_API_REST_PATTH;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.wireMockConfig().port(1990));

    @Test
    public void restClientTest() {

        stubFor(post(urlPathMatching(CONFLUENCE_API_REST_PATTH)).willReturn(ok()));

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Foo> request = new HttpEntity<>(new Foo());
        ResponseEntity<Foo> response = restTemplate
                .exchange(CONFLUENCE_URL_API_REST, HttpMethod.POST, request, Foo.class);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @JsonSerialize
    public class Foo implements Serializable {
    }
}
