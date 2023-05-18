@EditFarm
Feature: Test Edit Farm Page

    Scenario: Test Edit Farm 
        Given User select My Account EditFarm
        And User select Manage Farm EditFarm
        And User select on chosen farm EditFarm
        And User edit and doesnt fill in required farm details
        And User edit and fill in required farm details
        And User save farm edit
        And User select on chosen plot EditFarm
        And User edit and doesnt fill in required plot details
        And User edit and fill in required plot details
        And User select on chosen crop EditFarm
        And User edit and doesnt fill in required crop details
        And User edit and fill in required crop details
        And User select on chosen grade EditFarm
        And User edit and doesnt fill in required grade details
        Then User edit and fill in required grade details