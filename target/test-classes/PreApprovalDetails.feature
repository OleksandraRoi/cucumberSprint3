@regression @max
Feature: PreApproval Details

  Background: default steps till pre preapproval details
    Given The user is on the logging page
    When User entering email and password
    Then User going to PreApproval Details page

  Scenario:pass result
    When I got to the page ,I should be able to choose yes option in ARE YOU WORKING WITH A REALTOR?
    When I chose yes and I must to PROVIDE REALTOR`S NAME AND PHONE NUMBER OR EMAIL ADDRESS.
    Then I must be able to choose yes in Are you currently working with a loan officer
    When I chose yes The Purpose of Loan field should have a drop-down menu with options such as "Purchase a Home", "Refinance", and "Construction".
    Then The Estimated Purchase Price field should be a text input that allows the user to enter a dollar amount with up to two decimal places. This field should be required.
    When I filled Estimated Purchas I should be able to field Down Payment Amount
    Then Down Payment percentage should automatically be calculated as the user enters the down payment amount
    When I filled all information Your Loan Amount field should automatically update based on the purchase price minus the down payment amount
    Then The Source of Down Payment field should have a drop-down menu with options such as "Checking/Savings (most recent bank statement)", "Equity on Pending Sale (executed sales contract)", and "Other type of Down Payment".

  Scenario: invalid characters
    When I got to the page ,I should be able to choose no option in ARE YOU WORKING WITH A REALTOR?
    Then I must be able to choose no in Are you currently working with a loan officer
    When I chose yes The Purpose of Loan field should have a drop-down menu with options such as "Purchase a Home", "Refinance", and "Construction".
    Then The Estimated Purchase Price field should be a text input that allows the user to enter a dollar amount with up to two decimal places. This field should be required.
    When I filled Estimated Purchas I should be able to field Down Payment Amount
    Then Down Payment percentage should automatically be calculated as the user enters the down payment amount
    When I filled all information Your Loan Amount field should automatically update based on the purchase price minus the down payment amount
    Then The Source of Down Payment field should have a drop-down menu with options such as "Checking/Savings (most recent bank statement)", "Equity on Pending Sale (executed sales contract)", and "Other type of Down Payment".
