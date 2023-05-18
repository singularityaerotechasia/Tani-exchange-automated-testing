@EditAccountBuyer

Feature: Test Edit Account Page

    Scenario: Test Edit Account
        Given User select My Account EditAccount Buyer
        And User doesnt edit personal details and click save Buyer
        And User edit personal details and click save Buyer
        And User doesnt edit company details and click save Buyer
        Then User edit company details and click save Buyer
