Feature: Credit Report

  Background: default steps till Credit Report section
    Given The user is on the logging page
    When User entering email and password
    Then User going to Credit Report page

@nzr1
    Scenario: The Credit Report page should have a section where the user can order a credit report
    by choosing from checkboxes.
      Given The User is on Credit Report page
      Then The User should be able to see Yes and No select option in the Credit Report download checkbox

  @nzr2
      Scenario: The user should be able to select between two checkboxes labeled "Yes" and "No" to indicate
      whether they want to order a credit report or not.
        Given The User is on Credit Report page
        Then The User should be able to select Credit Report download by choosing Yes checkbox option
        Then The User should be able to reject Credit Report download by choosing No checkbox option

  @nzr3
        Scenario: If the user selects "Yes", they should be taken to a secure third-party website where they can
        order their credit report once they submit the application. The link to the third-party website should open
        in a new tab or window.
          Given The User is on Credit Report page
          When The User selects Yes in checkbox
          Then The User is transferred to a new window with secure third-party website where they can order their Credit Report

  @nzr4
          Scenario: If the user selects "No", they should not be taken to the third-party website and
          no credit report should be ordered.
            Given The User is on Credit Report page
            When The User selects No in checkbox
            Then The User is not transferred to a new window third-party website and Credit Report is not ordered