Feature: Sign in feature

As a potential user,I should be able to sign in to my mortgage account, to access my account information and perform necessary actions.

  Scenario: User should be greeted with a welcome message.
    Given User navigates to Sign in page
    When User is on Sign in page
    Then User should be greeted with a Welcome message


  Scenario: User should be able to sign with valid email address and password
    Given User is on Sign in page
    And sign in page should have 2 inputs email and password



  Scenario: User should not be able to sign in with incorrect email and password.
    Given User is on Sign in page
    When User enters incorrect email and password
    Then clicks on Sign In button
    And User should be not able to proceed

  Scenario: User should be able to sign up if he/she did not enter an email
    Given User is on Sign in page
    When User is living email blank
    Then user should not be able to click on submit





