Feature:  Adding a book to card

  Scenario: search and add python book
    Given User is on search page

    When I enter book "python in easy steps" and I select the category of books "Books"
    And I select the book
    And I click on the add button

    Then The book is displayed on"https://cart.payments.ebay.com/" and its price is 9.99 and the items number is 1

