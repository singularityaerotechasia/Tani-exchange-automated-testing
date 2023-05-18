@CreateDemand
Feature: Test Create Demand Page

    Scenario: Test Create Demand
        Given User select My Account CreateDemand Buyer
        And User select My Demand CreateDemand
        And User add New Demand
        And User doesnt fill in required demand details and click save
        And User fill in required demand details and click save
        And User doesnt upload image CreateDemand
        And User upload image but no image description CreateDemand
        Then User add image description CreateDemand