package stepDefinitions.api;

import io.cucumber.java.en.Then;
import utils.ApiUtils;

import java.util.Map;

public class newUsers {
    Integer usersId;

    @Then("the {string} query parameter is set to")
    public void the_query_parameter_is_set_to(String key) {
        usersId = ApiUtils.getResponse().path("user_id");
        ApiUtils.setRequestQueryParameter(key, usersId);
    }
    @Then("the body is set to")
    public void the_body_is_set_to_the(Map<String, String> body) {
        ApiUtils.setRequestBody(body);
    }
}
