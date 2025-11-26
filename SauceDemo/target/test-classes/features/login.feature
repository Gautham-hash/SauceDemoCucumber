Feature: Login functionality with Cucumber

  # Tag example
  @Smoke
  Scenario: Valid login using parameterization
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click login
    Then I should land on the products page

  @Regression
  Scenario: Login with multiple users using DataTable
    Given I am on the SauceDemo login page
    When I enter the following users
      | username       | password     |
      | standard_user  | secret_sauce |
      | locked_out_user| secret_sauce |
    Then I should land on the products page
