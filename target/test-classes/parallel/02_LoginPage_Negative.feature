@Negative
Feature: Test the Negative scenario of MIRO sign-up page

  Background:

    Given Enter the url of the MIRO Page
    When Verify the title of the page

  @sc-1
  Scenario Outline: 01-validating the error message when name field is blank

    And Enter the work email
    And Enter the password "<Password>"
    And click on Miro Terms checkbox
    And click on Get Started Button
    Then Don't enter any value in name, check the error message "<NameErrorMessage>"

    Examples:

      | Password    | NameErrorMessage        |
      | test@123456 | Please enter your name. |

  @sc-2
  Scenario Outline: 02-validating the error message when email field is blank

    And Enter the name "<Name>"
    And Enter the password "<Password>"
    And click on Miro Terms checkbox
    And click on Get Started Button
    Then Don't enter any value in email, check the error message "<EmailErrorMessage>"

    Examples:

      | Name   | Password    | EmailErrorMessage                |
      | Gaurav | test@123456 | Please enter your email address. |

  @sc-3
  Scenario Outline: 03-validating the error message when email field has invalid values

    And Enter the name "<Name>"
    And Enter the work email "<Email>"
    And Enter the password "<Password>"
    And click on Miro Terms checkbox
    And click on Get Started Button
    Then Enter invalid value in email textbox, check the error message "<InvalidEmailErrorMessage>"


    Examples:

      | Name   | Email              | Password      | InvalidEmailErrorMessage                                                          |
      | Gaurav | test@test@test.com | Test!@#123_12 | This doesn’t look like an email address. Please check it for typos and try again. |

  @sc-4

  Scenario Outline: 04-validating the error message when password value is less than 8 char

    And Enter the name "<Name>"
    And Enter the work email
    And Enter the password "<password>"
    And click on Miro Terms checkbox
    And click on Get Started Button
    Then Enter invalid value in password textbox, check the error message "<passwordErrorMessage>"

    Examples:

      | Name   | passwordErrorMessage                         | password |
      | Gaurav | Please use 8+ characters for secure password | Test     |

  @sc-5

  Scenario Outline: 05-validating the error message when password is set as blank

    And Enter the name "<Name>"
    And Enter the work email
    And click on Miro Terms checkbox
    And click on Get Started Button
    Then Don't enter any value in password, check the error message "<passwordErrorMessage>"


    Examples:

      | Name   |  | passwordErrorMessage        |
      | Gaurav |  | Please enter your password. |


  @sc-6

  Scenario Outline: 06-validating the error message when Miro terms are unchecked

    And Enter the name "<Name>"
    And Enter the work email
    And Enter the password "<Password>"
    And click on Get Started Button
    Then Terms should be unselected, check the error message "<termsErrorMessage>"

    Examples:

      | Name   | termsErrorMessage                       | Password   |
      | Gaurav | Please agree with the Terms to sign up. | test@12345 |



