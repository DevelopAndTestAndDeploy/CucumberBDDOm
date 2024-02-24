
Feature: Add to cart

#  Scenario: Add one quantity from store
#    Given I am on the store page
#    When I add "Blue Shoes" to the cart
#    Then I should see 1 "Blue Shoes" in the cart

  @smoke
 Scenario Outline: Add one quantity from store - examples
    Given I am on the store page
    When I add "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
   Examples:
     | product_name    |  |
     | Blue Shoes      |  |
     | Anchor Bracelet |  |



