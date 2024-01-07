Feature: Swipe Cards on the Swipe Section

  Scenario: User swipes cards to the left
    Given the user is at the Swipe section in the first card of the carousel
    When the user performs a left swipe on the cards
    Then the first card should be hidden
    And the second card should be visible
    And the second card dot should be selected


  Scenario: User swipes cards to the left
    Given the user is at the Swipe section in the second card of the carousel
    When the user performs a right swipe on the cards
    Then the second card should be hidden
    And the first card should be visible
    And the first card dot should be selected

