Feature: Electronic Consent

As a mortgage loan applicant, I want to provide electronic consent to receive and sign disclosures related to my loan application.

Background: Common steps for all scenarios
  Given The user is logged in
  Given The user is on the Econsent page


@1st
Scenario: User can provide electronic consent
  Given The user is on the electronic consent page
When The user enters their first name, last name, and email address
And The user clicks on the “Agree” radio button
Then The user should be able to proceed with the application
And The user should see a confirmation message on the next page

@2nd
Scenario: User cannot proceed without providing required information
  Given The user is on the electronic consent page
When The user leaves any required field empty
And The user clicks on the “Agree” radio button
Then The user should see an error message next to the empty field(s)
And The user should not be able to proceed with the application

@3rd
Scenario: User can review disclosures before providing consent
Given The user is on the electronic consent page
When The user clicks on the link to view the disclosures
Then The user should be taken to a page with the necessary disclosures related to the loan application
And The user should be able to read and review the disclosures before providing consent
And The user should be able to navigate back to the electronic consent page

@4th
Scenario: User can choose not to provide electronic consent
Given The user is on the electronic consent page
When The user clicks on the “Don’t Agree” radio button
Then The user should be redirected back to the main application flow
And The user should not be able to proceed with the application
And The user should see a message explaining that they cannot proceed without providing electronic consent.