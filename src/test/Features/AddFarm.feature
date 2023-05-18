@AddFarm
Feature: Test Add Farm Page

    Scenario: Test Add Farm 
        Given User select My Account AddFarm
        And User select Manage Farm
        And User select Add New Farm 
        And User fill in half create farm details 
        And User fill in create farm details 
        And User doesnt upload farm certificate and photos
        And User upload farm certificate and photos
        And User add Plot
        And User select crop and stock
        And User add crop and doesnt fill in crop details
        And User add crop and fill in crop details
        And User add grade and doesnt fill in grade details
        And User add grade and fill in grade details
        And User click Plot and doesnt fill plot details
        Then User click Plot and fill plot details