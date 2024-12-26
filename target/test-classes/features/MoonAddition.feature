@LoggedIn
Feature: Moon Addition
    As a user I want to add new moons to the Planetarium so I can update my findings

    Background: Moon Addition Starting Actions
        Given   the user is logged in on the home page


    Scenario: Users can add new moon to their planetarium with valid data input
    # TODO: make sure to use valid moon name/planet ID in step implementation
        And     the user selects moon from the dropdown
        When    the user provides a valid moon name
        And     the user provides a valid planet ID
        And     the user submits the moon data
        Then    the user should see the created moon on home page

    Scenario Outline: Users cannot add new moon to their planetarium with invalid data input
        And     the user selects moon from the dropdown
        When    the user provides moon name "<moon name>"
        And     the user provides planet ID "<planet ID>"
        And     the user submits the moon data
        Then    the user should get a browser alert saying "<alert>"
        And     the user should stay on the home page

    Examples:
    |moon name                       |planet ID|alert                  |
    |                                |1        |Invalid moon name|
    |This moon name is wayyy too long|1        |Invalid moon name|
    |oHno?!                          |1        |Invalid moon name|
    |Luna                            |1        |Invalid moon name|
    |Moon name-_-1                   |3        |Invalid planet id|