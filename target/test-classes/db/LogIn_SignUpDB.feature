Feature: User Story 1 - Log In and Sign Up DB

  As a user of Duobank Mortgage Application, I want to be able to sign up and log in securely using a
  database system that protects my personal and financial information, so that I can complete the
  mortgage application process with confidence.

  Background: Common steps for all scenarios
    Given The user is on the logging page

  Scenario: The database should be able to handle a large number of user signups without slowing down the system
    Given The database is running and available for use
    When Multiple users sign up simultaneously with unique information
    Then The database should handle the load without slowing down the system

  Scenario: Each user should have a unique username and email address associated with their account
    Given A user is on the sign-up page
    When The user enters an email address and a username that already exist in the database
    Then The user should get an error message "Email address or username already exists"
    And The email address or username should not be stored in the database

  Scenario: The "tbl_users" table should contain the following columns
    Given The database is running and available for use
    Then The "tbl_users" table should contain the following columns:
      | id | email | password | first_name | last_name | phone | image | type | created_at | modified_at | zone_id | church_id | country_id | active |

  Scenario: The "tbl_users" table should not allow duplicate email addresses to be stored
    Given A user is on the sign-up page
    When The user enters an email address that already exists in the database
    Then The user should get an error message "Email address already exists"
    And The email address should not be stored in the database

  Scenario: The "tbl_users" table should store a timestamp of when the user account was created
    Given A user is on the sign-up page
    When The user successfully signs up
    Then The "created_at" field in the "tbl_users" table should contain the timestamp of when the user's account was created

  Scenario: The database should store and encrypt user passwords in an MD5 hash
    Given A user is on the sign-up page
    When The user enters their password
    Then The password should be encrypted using an MD5 hash
    And The encrypted password should be stored in the "password" field of the "tbl_users" table

  Scenario: Upon successful submission of the sign-up information, the "Sign Up" page form fields should be mapped to their corresponding columns in the "tbl_users" table in the database
    Given A user is on the sign-up page
    When The user enters their information and clicks the "Sign Up" button
    Then The information should be stored in the corresponding columns in the "tbl_users" table
    And The user should be redirected to the login page.