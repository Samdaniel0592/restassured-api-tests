    package com.api.helpers;

    import io.restassured.response.Response;
    import static io.restassured.RestAssured.*;

    public class ApiClient {

        public static Response graphQLPost(String baseURI, String query) {
    String payload = String.format("{\"query\": \"%s\"}", query.replace("\"", "\\\""));

    return given()
            .baseUri(baseURI)
            .header("Content-Type", "application/json")
            .body(payload)
        .when()
            .post();
}

public static Response graphQLPostWithVariables(String baseURI, String query, String variablesJson) {
    String payload = String.format("{\"query\": \"%s\", \"variables\": %s}", 
                                    query.replace("\"", "\\\""), variablesJson);

    return given()
            .baseUri(baseURI)
            .header("Content-Type", "application/json")
            .body(payload)
        .when()
            .post();
}


        public static Response post(String baseURI, String endpoint, String payload) {
            return given()
                    .baseUri(baseURI)
                    .header("Content-Type", "application/json")
                    .body(payload)
                .when()
                    .post(endpoint);
        }

        public static Response get(String baseURI, String endpoint) {
            return given()
                    .baseUri(baseURI)
                    .header("Content-Type", "application/json")
                .when()
                    .get(endpoint);
        }
    }
