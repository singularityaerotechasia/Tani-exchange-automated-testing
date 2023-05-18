@EditProduct
Feature: Test Edit Product Page

    Scenario: Test Edit Product
        Given User select My Account EditProduct
        And User select Manage Product EditProduct
        And User select on chosen product EditProduct
        And User edit but doesnt fill the required product details and click save
        Then User edit and fill the product details and click save