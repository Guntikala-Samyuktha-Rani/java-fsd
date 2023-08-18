Feature: Buy Physics Books
@TC_101
Scenario: User can add a physics book to the cart and proceed to checkout
    Given User is on the Amazon website
    When User searches for "physics books for general reading"
    And User clicks on the first book in the search results
    And User adds the book to the cart
    And User proceeds to buy
    Then User should be on the sign-in page
    