package org.myCompany.stepDefinations;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class UserStepDefinitions {
    private Response response;

    @Given("the API base URI is set")
    public void theApiBaseUriIsSet() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @When("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
        response = given()
                .header("Content-Type", "application/json")
                .get(endpoint);
    }

    @When("I send a POST request to {string} with the payload:")
    public void iSendAPostRequestToWithThePayload(String endpoint, String payload) {
        response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "Status code mismatch!");
    }

    @Then("the response should contain {string}")
    public void theResponseShouldContain(String key) {
        Assert.assertTrue(response.getBody().asString().contains(key), "Response does not contain: " + key);
    }
}
