Feature: Login to saucedemo site
Background: 
Given saucedemi site is opened

Scenario Outline: Login with username and password

When I login with "<username>" and "<password>"
Then the login should be "<result>"

Examples:
| username | password | result
| standard_user | secret_user | success
| locked_out_user | secret_sauce | failure