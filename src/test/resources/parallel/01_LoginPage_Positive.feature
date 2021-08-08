@Positive

Feature: Test the signup page functionality of MIRO webpage

  Background:
    Given Enter the url of the MIRO Page
    When Verify the title of the page

  Scenario Outline: TC-Pos_01-Validating the sign-up flow
    And Enter the name "<Name>"
    And Enter the work email
    And Enter the password "<Password>"
    And click on Miro Terms checkbox
    And click on Get Started Button
    Then Verify the email address after singing up "<EmailVerificationMessage>"

    Examples:

      | Name   | Password    | EmailVerificationMessage |
      | Gaurav | test@123456 | Check your email         |


  Scenario: TC-Pos_02-Checking social media signup links
    And click on signup popup page



