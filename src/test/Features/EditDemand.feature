@EditDemand
Feature: Test Edit Demand Page

    Scenario: Test Edit Demand
        Given User select My Account EditDemand Buyer
        And User select My Demand EditDemand
        And User select chosen demand
        And User edit but doesnt fill in required demand details and click save
        Then User edit and fill in required demand details and click save