@api @8
Feature: usr story 8

  As a loan officer, I want to be able to retrieve a list of mortgage
  applications for a specific user, so that I can review their application
  status and history.

  Scenario: getting a user information
  Given the correct key provided and the user is authenticated
    And the "Authorization" header is set to JWT token generated from login endpoint
  When the "GET" request is sent to "/applications"
  Then the response log is shown
  Then the status code should be 201
  Then the following information should be displayed
  |Application ID|
  |Borrower First Name|
  |Borrower Last Name|
  |Borrower Middle Name|
  |Total Loan Amount|
    And the list of mortgage applications must be ordered by creation date newest to oldest
  And JSON response and "Content-Type" header as "application/json"
  And the response must be less than 2000 ms


  Scenario: getting a user information as an administrator
  Given the correct key provided and the user is authenticated
    And the "Authorization" header is set to JWT token generated from login endpoint
  When the "GET" request is sent to "/applications"
  Then the response log is shown
  Then the status code should be 201
  When the user making the request as an administrator, as type 1 user
  Then all mortgage applications in the system must be returned
  And the list of mortgage applications must be ordered by creation date (newest to oldest)
  And JSON response and "Content-Type" header as "application/json"
  And the response must be less than 2000 ms


  Scenario: getting a user information as not an administrator
  Given the correct key provided and the user is authenticated
    And the "Authorization" header is set to JWT token generated from login endpoint
  When the "GET" request is sent to "/applications"
  Then the response log is shown
  Then the status code should be 201
  When the user making the request as not an administrator
  Then only mortgage applications associated with the user's user ID must be returned
  And the list of mortgage applications must be ordered by creation date newest to oldest
  And JSON response and "Content-Type" header as "application/json"
  And the response must be less than 2000 ms


  Scenario: getting a user information with non existing ID
  Given the correct key provided and the user is authenticated
    And the "Authorization" header is set to JWT token generated from login endpoint
  When the "GET" request is sent to "/applications"
  Then the response log is shown
  Then the status code should be 201
  When there are no mortgage applications associated with the user ID
  Then an empty list must be returned
  And the list of mortgage applications must be ordered by creation date newest to oldest
  And JSON response and "Content-Type" header as "application/json"
  And the response must be less than 2000 ms

