@maxNew
Feature: summary
  Background: default steps till summary page
    Given The user is on the logging page
    When User entering email and password

  Scenario:Test Summary page
    Then User going to summary page
    When I got to summary page i should be able to click on PersonalnDetails
    When I got to summary page i should be able to click on PersonalnformationEdit page
    Then I should be able to go back to summary page and click on ExpenseEdit page
    When I clicked on ExpenseEdit I should be able go back to summary page to click on EmploymentIncomeEdit
    Then I must go back on summary page to click on OrderCreditEdit
    When I clicked on OrderCreditEdit I must to go back and click on eConsentEdit

  Scenario: Go to the summary page after first filled page
    Then I have to fill first page
    Then I should be able to go to the Summary page

    Scenario: Faill submit
      Then I have to fill first page
      Then I should be able to go to the Summary page
      When I filled only one page click on submit
