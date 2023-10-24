@ui @healthcheck


Feature: Check Bus Availability on Travelyaari.com

 Background:
    Given I am on the Travelyaari website homepage

  @availibilty
  Scenario Outline: Search for buses with available seats
   When I click on the Offers option
   Then I am on the Offers tab
   When I click on the "Book Now" button
    And I search for a bus from "<From_City>" to "<To_City>" 
  	And I select the date of journey 19/11/2023
    And I click the "Search Bus" button
    Then I should see a list of buses operators with available seats
    And the list should include buses with more than 4 seats available

    Examples:
      | From_City| To_City  |
      | Indore  | Bhopal   |


