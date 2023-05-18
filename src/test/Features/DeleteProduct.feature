@DeleteProduct
Feature: Test Delete Product Page

    Scenario: Test Delete Product 
        Given User select My Account DeleteProduct
        And User select Manage Product DeleteProduct
        And User select unpublish on chosen product
        And User click on Delete product
        And User cancel on Delete product
        Then User confirm on Delete product 