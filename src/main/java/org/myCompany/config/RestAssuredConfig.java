package org.myCompany.config;

import io.restassured.RestAssured;

public class RestAssuredConfig {
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";  // Base URI
    }
}
