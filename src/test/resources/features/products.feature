Feature: Product and purchase related functional tests

  Background:
    Given  User has navigated to main page

  Scenario: Find a product using search suggestions
    And user types chiffon dress into search field
    When user selects first suggestion
    Then product page is displayed


  Scenario: Find products using filters
    And user clicks Dresses in menu
    When user sets catalog filters to
      | Summer Dresses | M | White | In stock |
    Then product list contains items available in color white


  Scenario: Find products using search
    And user types pink blause into search field
    When user executes search
    Then list of search results is displayed


  Scenario: Comparing products
    And user clicks Dresses in menu
    And user adds item 0 to comparison
    And user adds item 1 to comparison
    When user clicks Compare
    Then 2 items are displayed in comparing list


  Scenario: Adding products to wish list while logged out
    And user clicks Dresses in menu
    And user opens product page of the first result
    When user clicks Add to wishlist on product quick view
    Then user is notified of logging in requirement
