Feature: feature to test automation skills
  @AutoExam
  Scenario: Validate simple navigation to the provided url
    Given browser is open and launch the url provided
    When user log-in his credentials, username and password
    And user click submit a new application
    And user fill-out the forms
    And user click the next button
    And user verify if all the inputted values displayed in the summary screen
    And user click validate and send button
    Then user is redirected to thank you page