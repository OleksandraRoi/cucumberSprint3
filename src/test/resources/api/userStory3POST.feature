@api @3
Feature: usr story 3

  As a mortgage application user, I want to be able to create a new
  user account so that I can apply for a mortgage and access my
  account information.

  Scenario: successfully posting new user
  Given the correct key provided and the user is authenticated
  Then the "Content-type" is "application/json"
  When the "POST" request is sent to "/user"
  Then the response log is shown
  When the new user was created
  Then the following information should be displayed
  """{
  "status" : 1,
  "http_code" : 201,
  "message" : "The user has been created.",
  "user_id" : "the ID of the newly created user account."
  }"""
  And JSON response and "Content-Type" header as "application/json"
  And the response must be less than 5000 ms


  Scenario: checking different scenarios with invalid input
  Given the correct key provided and the user is authenticated
  Then the "Content-type" is "application/json"
  When API key is not provided
  Then 401 Unauthorized status code with error message should be displayed
  When the following fields are missing or empty:
  |first_name|
  |last_name|
  |email|
  |password|
  Then API should return a 422 Unprocessable Entity error with a message ""
  When the email address is invalid
  Then API should return a 422 Unprocessable Entity error with a message ""
  When the password is invalid
  Then API should return a 422 Unprocessable Entity error with a message ""
  When the first name is invalid
  Then API should return a 422 Unprocessable Entity error with a message ""
  When the last name is invalid
  Then API should return a 422 Unprocessable Entity error with a message ""
  When the email address is already in use
    And JSON response and "Content-Type" header as "application/json"
    And the response must be less than 5000 ms
