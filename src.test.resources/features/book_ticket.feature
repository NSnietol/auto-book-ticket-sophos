Feature: Reserve a flight ticket
  As a web user
  I want to reserve a ticket in newtours page
  so I can travel



  Scenario: reserve a ticket in Mercury page
     Given the user opened  Mercury tours home page
     And the user logs into the page
     When the user searches for a flight
     And the user booked the flight
    Then The flight confirmation is displayed on the page


