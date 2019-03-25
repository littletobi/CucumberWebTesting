package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.RestAssuredExtensions;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RestAssuredJsonServerSteps {

    private static ResponseOptions<Response> response;

    @Given("^I perform GET operation for ([^\"]*) url$")
    public void iPerformGETOperationForUrl(String url) {
        response = RestAssuredExtensions.GetOps(url);
    }

    @And("^I perform GET operation with path parameter for url ([^\"]*)$")
    public void iPerformGETOperationWithPathParameterForUrl(String url, DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("id", data.get(0).get("id"));
        response = RestAssuredExtensions.GetOpsWithPathParameter(url, pathParams);
    }

    @Then("^There should be user with first name ([^\"]*) last name ([^\"]*) and email ([^\"]*)$")
    public void ThereShouldBeUserWithFirstNameLastNameAndEmail(String firstName, String lastName, String email) throws Throwable {
        assertThat(response.getBody().jsonPath().getString("firstName"), containsString(firstName)); //hamcrest
        assertEquals(true, response.getBody().jsonPath().get("lastName").equals(lastName));
        if (email.equals("empty")) {
            assertThat(response.getBody().jsonPath().get("email"), nullValue());
        } else {
            assertThat(response.getBody().jsonPath().getString("email"), containsString(email));
        }
    }

    @Then("^I should see users$")
    public void iShouldSeeUsers() {
        assertThat(response.getBody().jsonPath().get("firstName"), hasItems("Bill", "Tobi", "Mark")); //hamcrest
    }

    @Given("^I perform POST operation for url ([^\"]*) with body$")
    public void iPerformPOSTOperationForUrlUsersIdWithBody(String url, DataTable table) throws Throwable {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        //Set body
        HashMap<String, String> bodyParams = new HashMap<>();
        bodyParams.put("id", data.get(0).get("id"));
        bodyParams.put("firstName", data.get(0).get("firstName"));
        bodyParams.put("lastName", data.get(0).get("lastName"));
        bodyParams.put("email", data.get(0).get("email"));
        //Path params
        //Zeby nie tworzyc oddzielnej metody pomocniczej przekazuje pusty pathParams
        HashMap<String, String> pathParams = new HashMap<>();
        //Perform post operation
        response = RestAssuredExtensions.PostOpsWithBodyAndPathParams(url, pathParams, bodyParams);
    }

    @Then("^I should see the body has first name ([^\"]*) and lastName ([^\"]*)$")
    public void iShouldSeeTheBodyHasFirstNameAndLastName(String firstName, String lastName) throws Throwable {
        assertEquals(response.getStatusCode(), 201);
        assertThat(response.getBody().jsonPath().get("firstName"), equalTo(firstName));
        assertThat(response.getBody().jsonPath().get("lastName"), equalTo(lastName));
    }

    @Given("^I perform POST operation for url \"([^\"]*)\" with body and path$")
    public void iPerformPOSTOperationForUrlWithBodyAndPath(String url, DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        //Set body
        HashMap<String, String> bodyParams = new HashMap<>();
        bodyParams.put("countryName", data.get(0).get("countryName"));
        //Path params
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("countryNumberInPath", data.get(0).get("countryNumber"));
        //Perform post operation
        response = RestAssuredExtensions.PostOpsWithBodyAndPathParams(url, pathParams, bodyParams);
    }

    @Then("^I should see the body has country name ([^\"]*)$")
    public void iShouldSeeTheBodyHasCountry(String countryName) {
        assertThat(response.getBody().jsonPath().get("countryName"), equalTo(countryName));
    }


    @When("^I perform DELETE  operation for  url ([^\"]*)$")
    public void iPerformDELETEOperationForUrl(String url, DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("id", data.get(0).get("id"));
        //Perform delete operation
        RestAssuredExtensions.DeleteOpsWithPathParams(url, pathParams);
    }

    @Then("^There should not be user with first name ([^\"]*) and last name ([^\"]*)$")
    public void thereShouldNotBeUserWithFirstNameAndLastName(String firstName, String lastName) {
        assertNotEquals(response.getBody().jsonPath().get("firstName"), firstName);
        assertNotEquals(response.getBody().jsonPath().get("lastName"), lastName);
    }

    @Given("^I perform authentication operation for ([^\"]*)$")
    public void iPerformAuthenticationOperationFor(String url, DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        HashMap<String, String> bodyParams = new HashMap<>();
        bodyParams.put("email", data.get(0).get("email"));
        bodyParams.put("password", data.get(0).get("password"));
        HashMap<String, String> pathParams = new HashMap<>();
        response = RestAssuredExtensions.PostOpsWithBodyAndPathParams(url, pathParams, bodyParams);
    }

    @When("^I perform GET operation for ([^\"]*) url with token$")
    public void iPerformGETOperationForUrlWithToken(String url) {
        response = RestAssuredExtensions.GetOpsWithToken(url, response.getBody().jsonPath().get("access_token"));
    }
}


