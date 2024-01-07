Feature: Successful Sign Up

  Scenario: User successfully signs up for an account
    Given the user navigates at the Login section
    When the user navigates to the Signup section
    And fills all the required form data to sign up
    And completes the signup process clicking on the submit button
    Then the signup should be successfully completed


  Scenario: User signs up an  logs in successfully
    Given the user navigates at the Login section
    When the user fills in valid login credentials
    And submits the login form
    Then the login should be successful