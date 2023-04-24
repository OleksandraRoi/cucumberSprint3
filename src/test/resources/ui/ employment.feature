@regression1
Feature: Employment feature

  As a user applying for a mortgage loan, I want to provide my employment and
  income details to the bank, so that they can evaluate my eligibility for a loan

  Background: Common steps for all scenarios
    Given The user is on the logging page
    When User entering email and password
    Then User is locating employment page


  Scenario: Borrower Employment Information
    Given The user is on Employment page
    Then  User should see fields for
     |EMPLOYER NAME |
     |POSITION      |
     |CITY          |
     |STATE         |
     |START DATE    |
     |END DATE      |
    And STATE should be as dropdown list with all 50 US states and their two letter abbreviations.
    And The checkbox labeled This is my current job should be unchecked by default.
    And The section should have a Clear option that displays a warning popup about clearing the information.
    And The Clear option should only clear the information in that section, not any other sections.
#    And The user should be able to enter only valid information in each field.
    And The Add another employer button should let the user add a new section for another employer's information.
    And Each new section should contain the same fields as the first section.
    And EMPLOYER NAME should be a required input field
    And The next section should have a Clear option that displays a warning popup about clearing the information.
    And The Clear option should only clear the information in that section, not any other sections.
    And The user should be able to remove a section using the Remove option.

  Scenario: Borrower Gross Monthly Employment Income section
    Given The user is on Employment page
    Then User should see fields for income
     |GROSS MONTHLY INCOME|
     |MONTHLY OVERTIME    |
     |MONTHLY BONUSES     |
     |MONTHLY COMMISSIONS |
     |MONTHLY DIVIDENTS/INTEREST|
#     |Borrower Total Monthly Income|
    And All fields in this section should only accept numeric input (digits and decimal points) with a maximum of two decimal places. The maximum character limit for the fields should be 12 characters.
    And GROSS MONTHLY INCOME should be a required input field.
    And The Borrower Total Monthly Income field should be automatically calculated based on the other fields.

@b
  Scenario: Additional Gross Monthly Income section
    Given The user is on Employment page
    Then The user should see three sets of INCOME SOURCE dropdowns and Amount fields
    And INCOME SOURCE dropdown should have
     |Select One                       |
     |Alimony/Child Support            |
     |Social Security/Disability Income|
     |Unemployment Benefits            |
     |Interest and Dividends           |
     |VA Compensation                  |
     |Royalty Payments                 |
     |Other Types of Income            |


  Scenario: The user should be able to navigate to other sections using the "Previous" and "Next" buttons
    Given The user is on Employment page
    Then The Previous button should take the user to the previous section.
    And The Next button should take the user to the next section only if all required fields are filled in.
    And If a required field is not filled in, the Next button should not navigate to the next section and display an error message indicating which field needs to be filled in.
