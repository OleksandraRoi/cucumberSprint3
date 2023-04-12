@DB

Feature: User Story 5

  As a user of the Duobank Mortgage Application, I want my employment and income details to be
  securely stored in the database, so that I can easily provide and update this information through the
  Employment and Income page of the application.

  Background: Common steps for all scenarios
    Given The user is on the logging page
    When User entering email and password
    Then User is locating employment page

  Scenario: The database should have a table labeled “tbl_mortgage” that contains the following columns:
  employer_name, position, city, state, start_date, end_date, current_job, co_employer_name,
  co_position, co_city, co_state, co_start_date, co_end_date, co_current_job,
  gross_monthly_income, monthly_overtime, monthly_bonuses, monthly_commissions,
  monthly_dividends, c_gross_monthly_income, c_monthly_overtime, c_monthly_bonuses,
  c_monthly_commissions, c_monthly_dividends, add_belong, income_source, and amount.
    Given The user is on Employment page
    Then Database should contain the columns for Employments page
  | employer_name| position| city| state| start_date| end_date| current_job| co_employer_name| co_position| co_city| co_state| co_start_date| co_end_date| co_current_job| gross_monthly_income| monthly_overtime| monthly_bonuses| monthly_commissions| monthly_dividends| c_gross_monthly_income| c_monthly_overtime| c_monthly_bonuses| c_monthly_commissions| c_monthly_dividends| add_belong| income_source| and amount|

  Scenario: The "employer_name" and “gross_monthly_income” columns should be required and not
  empty.
    Given The user is on Employment page
    And EMPLOYER NAME should be a required input field
    And GROSS MONTHLY INCOME should be a required input field.
    And The database should have name and income values

  Scenario: The "state" column should store two-letter abbreviations of US states
    Given The user is on Employment page
    And STATE should be as dropdown list with all 50 US states and their two letter abbreviations.
    Then Database should contain 50 states abbreviations

  Scenario: The "income_source" column should only contain any of the following: Alimony/Child Support,
  Social Security/Disability Income, Unemployment Benefits, Interest and Dividends, VA
  Compensation, Royalty Payments, and Other Types of Income
    Given The user is on Employment page
    And INCOME SOURCE dropdown should have
      |Select One                       |
      |Alimony/Child Support            |
      |Social Security/Disability Income|
      |Unemployment Benefits            |
      |Interest and Dividends           |
      |VA Compensation                  |
      |Royalty Payments                 |
      |Other Types of Income            |
    Then Database income source table should have the following
      |Select One                       |
      |Alimony/Child Support            |
      |Social Security/Disability Income|
      |Unemployment Benefits            |
      |Interest and Dividends           |
      |VA Compensation                  |
      |Royalty Payments                 |
      |Other Types of Income            |

  Scenario: Upon successful submission of the page information, the "Employment and income details"
  page form fields should be mapped to their corresponding columns in the “tbl_mortagage” table
  in the database.
    Given The user is on Employment page
    When User successfully filling out the form
    Then Database should have the entered by user information


