Feature: Personal Information feature

  As a potential homebuyer, I want to use the Personal Information page of my bank's mortgage application
  to provide my personal details and co-borrower's details (if applicable) so that I can move forward with
  the mortgage application process.

  Background: Common steps for all scenarios
    Given The user is on the logging page
    When User entering email and password
    Then User is locating to personal info page

  Scenario: User can select only one check box
    Given The user is on Personalinfo page
    When User selects Rent
    Then Own should not be selected
    When User selects Own
    Then Rent should not be selected