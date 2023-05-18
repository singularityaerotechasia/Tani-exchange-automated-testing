@ReceiveOrder
Feature: Test Receive Order Page

    Scenario: Test Receive Order
        Given User select My Account Farmer ReceiveOrder 
        And User select Incoming Order Farmer
        And User select chosen order details Farmer
        And User select start delivery Farmer
        And User select Incoming Order Buyer
        And User select chosen order details Buyer
        And User select accept delivery Buyer
        Then User select done when order received Farmer