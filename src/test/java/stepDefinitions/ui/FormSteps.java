package stepDefinitions.ui;

import io.cucumber.java.en.Then;
import pages.ui.PathPage;

public class FormSteps {

    @Then("User is filling out form")
        public void user_is_filling_out_form(){
        new PathPage().finishOfApplication();
    }
}
