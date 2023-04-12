@DB

  Feature: User Story 4

    As a user of the Duobank Mortgage Application, I want to be able to easily provide and update
    information related to my current living situation and expenses through the Expenses page of the
    mortgage application. I expect this information to be securely stored in a database schema designed
    by the database developer to ensure the safety of my personal and financial data.

    Background: Common steps for all scenarios
      Given The user is on the logging page
      When User entering email and password
      Then User is locating expenses page

  Scenario: The database schema should have "tbl_mortagage" table that can store user information
  related to their living situation and expenses
    Given The database contains expenses page information
    |rent_own_status|monthly_rental_payment|first_mortagage_total_payment


  Scenario: The "rent_own_status" field should only allow two values, "Rent" and "Own".
    Given The user is on Expenses page
    Then User should be able to select Rent or Own
    And On the database Rent or Own should have a value

  Scenario: The "monthly_rental_payment" and "first_mortgage_total_payment" fields should only allow
  positive numeric values
    Given The user is on Expenses page
    When User selecting Rent check box
    And User is entering numeric value less than one in Rent
    Then User should get error message Please enter a value greater than or equal to zero in Rent
    And Rent should not be displayed on database
    Then User entering numeric Monthly Rental Payment
    And Rent should have entered value
    When User selecting Own check box
    And User is entering numeric value less than one in Own
    Then User should get error message Please enter a value greater than or equal to zero in Own
    And Own should not be displayed on database
    Then User entering numeric Monthly Mortgage Payment
    And Own should have entered value

  Scenario: Upon successful submission of the page information, the "Expenses" page form fields should be
  mapped to their corresponding columns in the “tbl_mortagage” table in the database
    Given The user is on Expenses page
    When User selecting Rent check box
    Then User entering numeric Monthly Rental Payment
    And Clicks on Next button
    Then The input information should be mapped in database correctly
