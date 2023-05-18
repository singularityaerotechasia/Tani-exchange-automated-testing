@DeleteFarm
Feature: Test Delete Farm Page

    Scenario: Test Delete Farm 
        Given User select My Account DeleteFarm
        And User select Manage Farm DeleteFarm
        And User select on chosen farm DeleteFarm
        And User select on chosen plot DeleteFarm
        And User click on Delete Plot
        And User cancel on Delete Plot
        And User confirm on Delete Plot
        And User select on chosen crop DeleteFarm
        And User click on Delete Grade
        And User cancel on Delete Grade
        And User confirm on Delete Grade
        And User click on Delete Crop
        And User cancel on Delete Crop
        And User confirm on Delete Crop
        And User click on Delete Farm
        And User cancel on Delete Farm
        Then User confirm on Delete Farm