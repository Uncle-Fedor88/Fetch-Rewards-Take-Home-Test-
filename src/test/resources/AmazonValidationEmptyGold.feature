Feature: Validation Empty Gold

  Scenario: Finding and Validation Empty Gold
    Given user navigates to "http://ec2-54-208-152-154.compute-1.amazonaws.com/"
    When user inserts gold to the left and right bowls and finds empty gold
    Then user press on empty gold and validates alert message "Yay! You find it!"

