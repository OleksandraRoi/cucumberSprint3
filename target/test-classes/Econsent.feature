Feature: Electronic Consent

As a mortgage loan applicant, I want to provide electronic consent to receive and sign disclosures related to my loan application.

Background: Common steps for all scenarios
  Given The user is logged in
  Given The user is on the Econsent page


@1st
Scenario: User can provide electronic consent filling up the form first name last name and email
  Given The user is on the electronic consent page
When The user enters their random first name, last name, and email address
Then The user should see the first name and last name filled up

@2nd
Scenario: User cannot proceed without providing required information
  Given The user is on the electronic consent page
Then The user should see Agree button selected by default


@3rd
Scenario: User can review disclosures before providing consent
Given The user is on the electronic consent page
When The user doe not agree to the terms and conditions of eConsent
  When The user enters their random first name, last name, and email address
Then User clicks on Do not agree button
And The user should be returned to the main application


@4th
Scenario: User can choose not to provide electronic consent
Given The user is on the electronic consent page
  When The user enters their random first name, last name, and email address
  When The user clicks on the  Agree button
Then The user should be able to proceed to the next step
