@api @3
Feature: usr story 3

  As a mortgage application user, I want to be able to create a new
  user account so that I can apply for a mortgage and access my
  account information.




  Scenario: successfully posting new user
  Given the correct key provided and the user is authenticated
  Then the header "Content-type" is "application/json"
    When the new user was created
      |username  |star               |
      |first_name|Luna               |
      |last_name |Watson             |
      |email     |lunawatson@mail.com|
      |password  |sky123Rock!        |
  When the "POST" request is sent to "/user"
  Then the response log is shown
    Given the user id is extracted
  Then the following key value information should be displayed
  |status   |
  |http_code|
  |message  |
  |user_id  |

    Given the correct key provided and the user is authenticated
    Then the header "Content-type" is "application/json"
    And the "id" query parameter is set to new user's id
    When the "DELETE" request is sent to "/user"
    Then the response log is shown
    Then the status code should be 200
  And JSON response and "Content-Type" header as "application/json"
  And the response must be less than 5000 ms
    And the response body key "message" must return "User deleted successfully"



  Scenario: error message is empty
    Given the correct key provided and the user is authenticated
    Then the header "Content-type" is "application/json"
    When the following fields are missing or empty:
   """
  {
  "username": "",
  "firstName": "",
  "lastName": "",
  "email": "",
  }
  """
    When the "POST" request is sent to "/user"
  Then API should return a 422 Unprocessable Entity error with a "message" "Missing or Invalid Required Fields!"

  Scenario: error message invalid email
    Given the correct key provided and the user is authenticated
    Then the header "Content-type" is "application/json"
    When the "email" is invalid
  """
  {
  "username": "rockstar",
  "firstName": "Eva",
  "lastName": "Adamova",
  "email": "123dd",
  "password": "Pass123!"
  }
  """

    When the "POST" request is sent to "/user"
  Then API should return a 422 Unprocessable Entity error with a "message" "Invalid Email Address!"
    Then the response log is shown
    And JSON response and "Content-Type" header as "application/json"
    And the response must be less than 5000 ms


  Scenario: error message invalid password
    Given the correct key provided and the user is authenticated
    Then the header "Content-type" is "application/json"
    When the "password" is invalid

"""
  {
  "username": "rockstar",
  "firstName": "Eva",
  "lastName": "Adamova",
  "email": "123eva@gmail.com",
  "password": "123"
  }
  """
    When the "POST" request is sent to "/user"
  Then API should return a 422 Unprocessable Entity error with a "message" "Password must be at least 8 characters long and contain at least one uppercase character, one lowercase character, one number, and one special symbol (!@#$%^&*()-_=+{};:,<.>)!"
    And the response log is shown
    And JSON response and "Content-Type" header as "application/json"
    And the response must be less than 5000 ms

  Scenario: error message invalid first name
    Given the correct key provided and the user is authenticated
    Then the header "Content-type" is "application/json"
    When the "first name" is invalid
"""
  {
  "username": "rockstar",
  "firstName": "E",
  "lastName": "Adamova",
  "email": "123eva@gmail.com",
  "password": "Pass123!"
  }
  """
    When the "POST" request is sent to "/user"
  Then API should return a 422 Unprocessable Entity error with a "message" "First name must be at least 2 characters long!"
    And the response log is shown
    And JSON response and "Content-Type" header as "application/json"
    And the response must be less than 5000 ms

  Scenario: error message invalid last name
    Given the correct key provided and the user is authenticated
    Then the header "Content-type" is "application/json"
    When the "last name" is invalid
"""
  {
  "username": "rockstar",
  "firstName": "Eva",
  "lastName": "A",
  "email": "123eva@gmail.com",
  "password": "Pass123!"
  }
  """
    When the "POST" request is sent to "/user"
  Then API should return a 422 Unprocessable Entity error with a "message" "Last name must be at least 2 characters long!"
    And the response log is shown
    And JSON response and "Content-Type" header as "application/json"
    And the response must be less than 5000 ms

  Scenario: error message email in use
    Given the correct key provided and the user is authenticated
    Then the header "Content-type" is "application/json"
    When the email address is already in use
"""
  {
  "username": "rockstar",
  "firstName": "Eva",
  "lastName": "Adamova",
  "email": "shella.ferry@yahoo.com",
  "password": "Pass123!"
  }
  """
    When the "POST" request is sent to "/user"
    Then API should return a 422 Unprocessable Entity error with a "message" "This e-mail is already in use!"
    Then the response log is shown
    And JSON response and "Content-Type" header as "application/json"
    And the response must be less than 5000 ms


  Scenario: API key is not provided error
    When API key is not provided
    Then the response log is shown
    Then 401 Unauthorized status code with error "message" "Invalid or missing API Key. Provide a valid api key with 'api_key' query parameter." should be displayed
