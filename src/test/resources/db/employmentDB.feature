@DB
Feature: User Story 5

  As a user of the Duobank Mortgage Application, I want my employment and income details to be
  securely stored in the database, so that I can easily provide and update this information through the
  Employment and Income page of the application.

@db_only1
  Scenario: The database should have a table labeled “tbl_mortgage” that contains the following columns:
  employer_name, position, city, state, start_date, end_date, current_job, co_employer_name,
  co_position, co_city, co_state, co_start_date, co_end_date, co_current_job,
  gross_monthly_income, monthly_overtime, monthly_bonuses, monthly_commissions,
  monthly_dividends, c_gross_monthly_income, c_monthly_overtime, c_monthly_bonuses,
  c_monthly_commissions, c_monthly_dividends, add_belong, income_source, and amount.
    Given Database should contain the columns for Employments page
  |employer_name|
  |position|
  |city|
  |state|
  |start_date|
  |end_date|
  |current_job|
  |co_employer_name|
  |co_position|
  |co_city|
  |co_state|
  |co_start_date|
  |co_end_date|
  |co_current_job|
  |gross_monthly_income|
  |monthly_over_time|
  |monthly_bonuses|
  |monthly_commision|
  |monthly_dividents|
  |c_gross_monthly_income|
  |c_monthly_over_time|
  |c_monthly_bonuses|
  |c_monthly_commision|
  |c_monthly_dividents|
  |add_belong|
  |income_source|
  |amount|

  @db_only1
  Scenario: The "employer_name" and “gross_monthly_income” columns should be required and not empty.
    Given The database should have name and income values and not be null

  @db_only1
  Scenario: The "state" column should store two-letter abbreviations of US states
    Given Database should contain states abbreviations

#  @uiSide
  Scenario: Filling out form on the UI side with different choices of income
    Then User fills out the form with different income sources

  @db_only1
  Scenario: The "income_source" column should only contain any of the following: Alimony/Child Support,
  Social Security/Disability Income, Unemployment Benefits, Interest and Dividends, VA
  Compensation, Royalty Payments, and Other Types of Income
    Then Database income source table should have one the following
      |Alimony/Child Support            |
      |Social Security/Disability Income|
      |Unemployment Benefits            |
      |Interest and Dividends           |
      |VA Compensation                  |
      |Royalty Payments                 |
      |Other Types of Income            |

    @mapping
  Scenario: Upon successful submission of the page information, the "Employment and income details"
  page form fields should be mapped to their corresponding columns in the “tbl_mortagage” table
  in the database.
    Given The user filling out employment form
      |employer_name   |position  |city       |state|start_date|gross_monthly_income|monthly_overtime|monthly_bonuses|monthly_commision|monthly_dividents|income_source        |amount|
      |Consulting LLC  |accountant|Arlington  |VA   |2016-02-02|5000                |100             |500            |200                |1000             |Other Types of Income|10000 |
    Then Database should have the entered by user information mapped accordingly
      |employer_name   |position  |city       |state|start_date|gross_monthly_income|monthly_overtime|monthly_bonuses|monthly_commision|monthly_dividents|income_source        |amount|
      |Consulting LLC  |accountant|Arlington  |VA   |2016-02-02|5000                |100             |500            |200                |1000             |Other Types of Income|10000 |

