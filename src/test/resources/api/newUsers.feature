@api @admin

  Feature: admin

Scenario: New user created for Admin
Given the correct key provided and the user is authenticated
Then the header "Content-type" is "application/json"
When the new user was created
|username  |moonlight            |
|first_name|Leya                 |
|last_name |Western              |
|email     |layla@mail.com       |
|password  |laylaW333!           |
When the "POST" request is sent to "/user"
  Then the status code should be 201
  Then the user id is extracted


  @patch
  Scenario: user into Admin
    Given the correct key provided and the user is authenticated
    Then the header "Content-type" is "application/json"
   Then the "id" query parameter is set to
    Then the response log is shown
And the body is set to
| type |  1   |
When the "PATCH" request is sent to "/user"
Then the response log is shown
Then the status code should be 200


    Scenario: New user created
      Given the correct key provided and the user is authenticated
      Then the header "Content-type" is "application/json"
      When the new user was created
        |username  |user123            |
        |first_name|Jeff               |
        |last_name |Hardy              |
        |email     |jeffh@mail.com     |
        |password  |Jeff333!           |
      When the "POST" request is sent to "/user"
      Then the status code should be 201