@LoggedIn
Feature: Planet Addition
    As a user I want to add new planets to the Planetarium so I can update my findings
    
    Background: Planet Addition Starting Actions
        Given   the user is logged in on the home page

    Scenario: Users can add new planet to their planetarium with valid data input
    # TODO: make sure to use valid planet name/file type in step implementation
        And     the user selects planet from the dropdown
        When    the user provides a valid planet name
        And     the user provides a valid file type
        And     the user submits the planet data
        Then    the user should see the created planet on home page

    Scenario Outline: Users cannot add new planet to their planetarium with invalid data input
        And     the user selects planet from the dropdown
        When    the user provides planet name "<planet name>"
        And     the user provides file type "<file type>"
        And     the user submits the planet data
        Then    the user should get a browser alert saying "<alert>"
        And     the user should stay on the home page

    Examples:
    |planet name                       |file type                                                                                                                |alert                    |
    |                                  |C:\\Users\\nafis\\Desktop\\Revature\\Project 1\\Planetarium\\src\\test\\resources\\Celestial-Images\\planet-2.jpg        |Invalid planet name|
    |This planet name is wayyy too long|C:\\Users\\nafis\\Desktop\\Revature\\Project 1\\Planetarium\\src\\test\\resources\\Celestial-Images\\planet-2.jpg        |Invalid planet name|
    |oHno?!                            |C:\\Users\\nafis\\Desktop\\Revature\\Project 1\\Planetarium\\src\\test\\resources\\Celestial-Images\\planet-2.jpg        |Invalid planet name|
    |Earth                             |C:\\Users\\nafis\\Desktop\\Revature\\Project 1\\Planetarium\\src\\test\\resources\\Celestial-Images\\planet-2.jpg        |Invalid planet name|
    |Planet name-_-1                   |C:\\Users\\nafis\\Desktop\\Revature\\Project 1\\Planetarium\\src\\test\\resources\\Celestial-Images\\planets.pdf         |invalid file type alert  |