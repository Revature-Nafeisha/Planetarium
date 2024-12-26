Feature: User Login
    As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

    Background: User Login Starting Actions
        Given   the user is on the login page
        
    Scenario: Users can login with valid credentials
        When    the user provides an existing username
        And     the user provides the correct password
        And     the user submits the credentials for log in
        Then    the user should be redirected to the home page

    Scenario Outline: Users cannot login with invalid credentials
        When    the user provides username "<username>" for log in
        And     the user provides password "<password>" for log in
        And     the user submits the credentials for log in
        Then    the user should get a browser alert saying Invalid credentials
        And     the user should stay on the login page

    Examples: 
    |username   |password       |
    |Batman     |b0Ts           |
    |Robin      |Iamthenight1939|
    |Robin      |b0Ts           |
   