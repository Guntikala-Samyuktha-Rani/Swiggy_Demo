Feature: Swiggy Order Placement

@TC-101
Scenario: Place an order on Swiggy
  Given I am on the Swiggy website
  When I enter my delivery location as "Hyderabad"
  And I select a restaurant 
  And I select the first dish available
  And I add the dish to the cart
  And I click on the cart icon to check out
  Then I should see the message to log in or sign up


