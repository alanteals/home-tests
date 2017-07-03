package rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class JsonPrettyPrinterTest {

    final String JSON_STRING = "{\"user\":{\"createdAt\":\"2017-01-01T22:00:00.000Z\"," +
            "\"userId\":\"1234\",\"firstName\":\"Dev\"," +
            "\"lastName1\":\"Null\",\"email\":\"devnull@mail.com\"}}";

    final String EXPECTED_JSON_STRING = "{\n" +
            "  \"user\" : {\n" +
            "    \"createdAt\" : \"2017-01-01T22:00:00.000Z\",\n" +
            "    \"userId\" : \"1234\",\n" +
            "    \"firstName\" : \"Dev\",\n" +
            "    \"lastName1\" : \"Null\",\n" +
            "    \"email\" : \"devnull@mail.com\"\n" +
            "  }\n" +
            "}";

    private ObjectMapper objectMapper;
    private Object jsonObject;

    @Before
    public void setUp() throws IOException {
        objectMapper = new ObjectMapper();
        jsonObject = objectMapper.readValue(JSON_STRING, Object.class);
    }

    @Test
    public void prettyFormatWithStringTest() throws IOException {

        // Really necessary the deserialization first.
        String actual = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        System.out.println(actual);

        Assert.assertEquals(EXPECTED_JSON_STRING, actual);
    }

    @Test
    public void prettyFormatWithObjectTest() throws JsonProcessingException {

        ClientRequest clientRequest = Mockito.mock(ClientRequest.class);
        Mockito.when(clientRequest.getEntity()).thenReturn(jsonObject);

        String actual = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientRequest.getEntity());
        System.out.println(actual);

        Assert.assertEquals(EXPECTED_JSON_STRING, actual);
    }

    @Test
    public void prettyFormatWithCastToObjectTest() throws IOException {

        ClientRequest clientRequest = Mockito.mock(ClientRequest.class);
        Mockito.when(clientRequest.getEntity()).thenReturn(JSON_STRING);

        Object jsonObject = objectMapper.readValue(clientRequest.getEntity().toString(), Object.class);

        String actual = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        System.out.println(actual);

        Assert.assertEquals(EXPECTED_JSON_STRING, actual);
    }
}
