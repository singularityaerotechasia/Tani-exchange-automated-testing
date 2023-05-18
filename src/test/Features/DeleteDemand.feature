@DeleteDemand
Feature: Test Delete Demand Page

    Scenario: Test Delete Demand
        Given User select My Account DeleteDemand Buyer
        And User select My Demand DeleteDemand
        And User click delete on chosen demand
        And User cancel delete demand
        Then User confirm delete demand