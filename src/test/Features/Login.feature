@Login
Feature: Test Login Page

    Scenario: Test Login
        Given User click login
        And User fill in requested login information
        And User click Next buttonn
        And User fill half information
        Then User fill wrong information