@ManageOrder
Feature: Test Manage Order Page

    Scenario: Test Manage Order
        Given User select My Account ManageOrder
        And User select cart
        And User click delete on chosen order
        And User cancel delete on chosen order
        And User confirm delete on chosen order
        And User click on delivery and payment but no order
        And User click on delivery and payment with order
        And User doesnt fill in required delivery and payment details
        And User fill in required delivery and payment details
        And User track delivery
        Then User go back to catalogue