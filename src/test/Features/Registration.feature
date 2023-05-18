@Registration

Feature: Test Registration Page

    Scenario: Test Registration
        Given User launch Tani Exchange
        And User try Register Route 1
        And User try Register Route 2
        And User select Sign up button
        And User fill half required account details
        And User click Next button
        And User select Registration role
        And User fill required company details 
        And User fill requested profile information
        Then User click Save button