@EditAccountFarmer

Feature: Test Edit Account Page

    Scenario: Test Edit Account
        Given User select My Account EditAccount Farmer
        And User doesnt edit personal details and click save Farmer
        And User edit personal details and click save Farmer
        And User doesnt edit company details and click save Farmer
        Then User edit company details and click save Farmer
