@api @login
Feature: login to generate tokens

  Scenario: Admin login in
    Given the correct key provided and the user is authenticated
    And the body input has the existing admin username and password
    When the "POST" request is sent to "/login"
    Then the response log is shown
    Then the status code should be 200
    And the JW token is generated
    And  the response must be less than 2000 ms
  And the response body key "message" must return "You've successfully logged in!"
    And the response body key "success" must return be true



  Scenario: User login in
    Given the correct key provided and the user is authenticated
    And the body input has the existing username and password
    When the "POST" request is sent to "/login"
    Then the response log is shown
    Then the status code should be 200
    And the JW token is generated
    And  the response must be less than 2000 ms
    And the response body key "message" must return "You've successfully logged in!"
    And the response body key "success" must return be true