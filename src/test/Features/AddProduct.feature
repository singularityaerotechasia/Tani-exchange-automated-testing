@AddProduct
Feature: Test Add Product Page

    Scenario: Test Add Product
        Given User select My Account AddProduct
        And User select Manage Product AddProduct
        And User add New Product
        And User doesnt fill the product details and click save
        And User fill the product details and click save
        And User view unpublished product
        And User doesnt upload image
        And User upload images but not image description
        And User add image description
        Then User publish product
        
