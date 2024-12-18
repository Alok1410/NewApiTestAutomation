package org.myCompany.testcases;

import org.myCompany.services.UserService;
import org.myCompany.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class UserAPITests {
    private UserService userService;
    @BeforeClass
    public void setup() {
        userService = new UserService();
        RestAssuredConfig.setup();
    }

    @Test
    public void testGetUsers() {

        Response response = userService.getUsers();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        System.out.println("Response: " + response.body().asString());
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"John\", \"job\": \"developer\" }";
        Response response = userService.createUser(requestBody);
        Assert.assertEquals(response.getStatusCode(), 201, "Status code mismatch!");
        System.out.println("Response: " + response.body().asString());
    }




    @Test
    public void testGetUsersSchemaValidation() {
        Response response = userService.getUsers();
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/user-schema.json"));
    }




}
