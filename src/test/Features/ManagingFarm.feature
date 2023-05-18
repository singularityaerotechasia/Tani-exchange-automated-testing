@ManageFarm
Feature: Test Manage Farm Page

    Scenario: Test Manage Farm
        Given User select My Account ManageFarm
        And User select Manage Farm ManageFarm
        And User select on chosen farm ManageFarm
        And User select on chosen plot ManageFarm
        Then User select on crop and stock ManageFarm