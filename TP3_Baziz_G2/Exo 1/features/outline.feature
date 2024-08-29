Feature:  Determinant calulator

  Scenario: 3*3 matrix determinant
    Given I have a matrix
      | -1 | 2 | 5  |
      | 1  | 2 | 3  |
      | -2 | 8 | 10 |
    When I compute the determinant

    Then I should have 32.0

