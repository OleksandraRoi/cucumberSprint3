@max @db_only@DB
Feature: User story 2

  As a user of Duobank Mortgage Application, I want my Preapproval Details page data to be stored in
  the database, so that I can access it later and the bank can process my mortgage application.

#  Background:connection
#    Given conect to Data


  Scenario:test one check names
    Then tbl_mortagage should be stored in the following order
        |    id              |
        |    realtor_status  |
        |      realtor_info  |
        |loan_officer_status |
        |purpose_loan        |
        |est_purchase_price  |
        |down_payment        |
        |down_payment_percent|
        |total_loan_amount   |
        |src_down_payment    |
        |add_fund_available  |

    Scenario: realtor_status and loan_officer_status check
      Then realtor_status and loan_officer_status column values be stored as integers 1 or 2

    Scenario: The database should ensure that each mortgage application is associated with a unique
    identifier (id)
      Then check if an id is unique

    Scenario: If the user selects "Yes" for the realtor question,realtor_info field is not empty.
      Then check all Yes column in realtor_info

    Scenario: check purpose_loan column
      Then purpose_loan column should contains "Purchase a Home" or "Refinance" or "Construction"


