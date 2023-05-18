@ApplyDemand
Feature: Test Apply Demand Page

    Scenario: Test Apply Demand
        Given User select My Account ApplyDemand Farmer
        And User select Market Demand 
        And User click on chosen demand ApplyDemand
        And User doesnt select on demand grade and apply ApplyDemand
        And User select on demand grade and apply ApplyDemand
        And User already apply
        Then User go back to Market Demand