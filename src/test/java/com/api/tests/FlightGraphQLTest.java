package com.api.tests;

import com.api.helpers.ApiClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FlightGraphQLTest {

    @Test(groups = "regression")
    public void testFlightQueryBasic() {
        String baseURI = "https://countries.trevorblades.com/"; // Free public GraphQL API

        String query = "query { country(code: \"IN\") { name, capital, emoji } }";

        Response response = ApiClient.graphQLPost(baseURI, query);

        assertEquals(response.statusCode(), 200);
        assertTrue(response.asString().contains("India"));
        assertTrue(response.asString().contains("New Delhi"));

        System.out.println("Response:\n" + response.asPrettyString());
    }
}
