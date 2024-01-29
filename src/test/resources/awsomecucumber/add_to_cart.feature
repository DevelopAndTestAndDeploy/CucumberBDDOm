Feature: Add to cart

  Scenario: Add one quantity from store
    Given I am on the store page
    When I add "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes" in the cart