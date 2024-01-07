Feature: Bottom Menu Navigation

  Scenario: Navigate to Drag Section
    Given the user is on the Home screen
    When the user taps the Drag icon on the bottom menu bar
    Then validate Drag section elements

  Scenario: Navigate to Swipe Forms Section
    Given the user is on the Home screen
    When the user taps the Swipe Forms icon on the bottom menu bar
    Then validate Swipe Forms section elements

  Scenario: Navigate to Login Section
    Given the user is on the Home screen
    When the user taps the Login icon on the bottom menu bar
    Then validate Login section elements

  Scenario: Navigate to Home Section
    Given the user is not in home Section
    When the user taps the Home icon on the bottom menu bar
    Then validate Home section elements

  Scenario: Navigate to Webview Screen
    Given the user is on the Home screen
    When the user taps the Webview icon on the bottom menu bar
    Then validate Webview screen elements