@AcceptDemand
Feature: Test Accept Demand Page

    Scenario: Test Accept Demand
        Given User select My Account AcceptDemand Buyer
        And User select My Demand Buyer
        And User click on chosen demand AcceptDemand
        And User click on view farm AcceptDemand
        And User click on accept demand
        And User cancel accept demand
        And User confirm accept demand
        Then User go back to My Demand