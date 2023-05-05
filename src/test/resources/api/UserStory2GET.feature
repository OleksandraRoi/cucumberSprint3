@api @2
Feature: user story 2

  As a user of the mortgage application, I want to be able to retrieve a specific user's information by ID through an API endpoint.

  Scenario: Retrieve user successfully
    Given the correct API key provided
    And  the "ID" parameter is "40"
    Then I send a "GET" request with a valid ID to the endpoint "/user"
    Then the response log should be displayed
    Then  response  should be displayed 200
    And the response "Content-Type" header should be "application/json"
    When I send "GET" request with invalid user ID as a query parameter
    Then Then I should receive body key "message" should be "Invalid or missing API KEy. API key must be provided as an 'api_key' query parameter."
    And  response status code should be  400
