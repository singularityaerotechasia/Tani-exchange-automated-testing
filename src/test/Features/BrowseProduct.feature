@BrowseProduct
Feature: Test Browse Product Page

    Scenario: Test Browse Product
        Given User select farmer produce when not login
        And User view and scroll page
        And User choose and view product
        And User continue browsing
        And User select farm details in product details page
        And User doesnt fill in details on product details page
        And User fill in details on product details page
        And User view cart
        Then User continue shopping