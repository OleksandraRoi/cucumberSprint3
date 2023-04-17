package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp_LogInDB {

    // US1
    @Given("The database is running and available for use")
    public void the_database_is_running_and_available_for_use() {

    }

    @When("Multiple users sign up simultaneously with unique information")
    public void multiple_users_sign_up_simultaneously_with_unique_information() {

    }

    @Then("The database should handle the load without slowing down the system")
    public void the_database_should_handle_the_load_without_slowing_down_the_system() {

    }

    // US2
    @Given("A user is on the sign-up page")
    public void a_user_is_on_the_sign_up_page() {

    }

    @When("The user enters an email address and a username that already exist in the database")
    public void the_user_enters_an_email_address_and_a_username_that_already_exist_in_the_database() {

    }

    @Then("The user should get an error message {string}")
    public void the_user_should_get_an_error_message(String string) {

    }

    @Then("The email address or username should not be stored in the database")
    public void the_email_address_or_username_should_not_be_stored_in_the_database() {

    }

    // US3
    @Then("The {string} table should contain the following columns:")
    public void the_table_should_contain_the_following_columns(String string, io.cucumber.datatable.DataTable dataTable) {

    }

    // US4
    @When("The user enters an email address that already exists in the database")
    public void the_user_enters_an_email_address_that_already_exists_in_the_database() {

    }

    @Then("The email address should not be stored in the database")
    public void the_email_address_should_not_be_stored_in_the_database() {

    }

    // US5
    @When("The user successfully signs up")
    public void the_user_successfully_signs_up() {

    }

    @Then("The {string} field in the {string} table should contain the timestamp of when the user's account was created")
    public void the_field_in_the_table_should_contain_the_timestamp_of_when_the_user_s_account_was_created(String string, String string2) {

    }

    // US6
    @When("The user enters their password")
    public void the_user_enters_their_password() {

    }

    @Then("The password should be encrypted using an MD5 hash")
    public void the_password_should_be_encrypted_using_an_md5_hash() {

    }

    @Then("The encrypted password should be stored in the {string} field of the {string} table")
    public void the_encrypted_password_should_be_stored_in_the_field_of_the_table(String string, String string2) {

    }

    // US7
    @When("The user enters their information and clicks the {string} button")
    public void the_user_enters_their_information_and_clicks_the_button(String string) {

    }

    @Then("The information should be stored in the corresponding columns in the {string} table")
    public void the_information_should_be_stored_in_the_corresponding_columns_in_the_table(String string) {

    }

    @Then("The user should be redirected to the login page.")
    public void the_user_should_be_redirected_to_the_login_page() {

    }


}
