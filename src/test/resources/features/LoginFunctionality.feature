Feature: Login Functionality

  Scenario Outline: Happy scenario - validate that user can login with valid credentials and complete order successfully
    Given user is in login page
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on Login button
    Then user is redirected to the home page
    When user adds an item to cart
    And user clicks on cart icon
    Then cart page is opened
    When user clicks on checkout button
    Then user is redirected to the user information page
    When user enters first name "<firstName>"
    And user enters last name "<lastName>"
    And user enters zipcode "<zipCode>"
    And user clicks on continue button
    Then checkout overview page is opened
    When user clicks on finish button
    Then confirmation page is displayed with thank you message

    Examples:
      | username      | password     | firstName | lastName     | zipCode |
      | standard_user | secret_sauce | Doaa      | Abdelfattah  | 02      |

  Scenario Outline: Negative scenario - validate that user can't login with invalid credentials
    Given user is in login page
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on Login button
    Then user can't login and error message displayed

    Examples:
      | username          | password     |
      | unauthorized_user | wrong_password |
