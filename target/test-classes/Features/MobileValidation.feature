#Author: karthi@your.domain.com
@regression
Feature: Mobile

 Background:
    Given user launches flipkart application
    And user login by entering valid crendentials

@smoke3
  Scenario: Mobile Name validation
    When user search mobile
    And user click on the mobile name
    Then user validate the mobile names

@sanity @sanity1
  Scenario: Mobile Name validation one dim list
    When user search mobile by one dim list
      | realme | iPhone | SAMSUNG |
    And user click on the mobile name
    Then user validate the mobile names

@smoke
  Scenario: Mobile Name validation one dim map
    When user search mobile by one dim map
      | 1 | realme  |
      | 2 | iPhone  |
      | 3 | SAMSUNG |
    And user click on the mobile name
    Then user validate the mobile names

  Scenario Outline: Mobile Name validation
    When user search mobile "<phone>"
    And user click on the mobile name
    Then user validate the mobile names

    Examples: 
      | phone   |RAM|
      | realme  |32 |
      | iPhone  |32 |
      | SAMSUNG |32 |
