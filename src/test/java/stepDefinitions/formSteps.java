package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.PathPage;

public class formSteps {

    @Then("User is filling out form")
        public void user_is_filling_out_form(){
        new PathPage().finishOfApplication();
    }
}
