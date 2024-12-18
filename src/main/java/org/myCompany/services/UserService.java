package org.myCompany.services;


import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {
    @Step("Get all users")
    public Response getUsers() {
        return given()
                .header("Content-Type", "application/json")
                .get("/users");
    }

    public Response createUser(String requestBody) {
        return given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/users");
    }

}

