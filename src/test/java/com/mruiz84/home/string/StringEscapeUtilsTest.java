package com.mruiz84.home.string;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Test;

public class StringEscapeUtilsTest {

    final String JSON_STRING = "{\"user\":{\"createdAt\":\"2017-01-01T22:00:00.000Z\"," +
            "\"userId\":\"1234\",\"firstName\":\"Dev\"," +
            "\"lastName1\":\"Null\",\"email\":\"devnull@mail.com\"}}";

    final String EXPECTED = JSON_STRING;

    @Test
    public void test1() {
        String unescapeJson = StringEscapeUtils.unescapeJson(JSON_STRING);
        System.out.println(unescapeJson);

        Assert.assertEquals(EXPECTED, unescapeJson);
    }
}
