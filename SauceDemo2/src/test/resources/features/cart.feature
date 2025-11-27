Feature: Add product to cart
Background:
Given saucedemi site is opened
When I login with "standard_user" and "secret_sauce"
Then the login should be "success"

Scenario: Add backpack to cart and verify cart count
When I add "Sauce Labs Backpack" to the cart
Then the cart should conatin "1"