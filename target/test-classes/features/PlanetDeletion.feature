@LoggedIn
Feature: Planet Deletion
    As a user I want to remove planets from the Planetarium so I can correct my findings

    Background: Deleting Planet Starting Actions
        Given   the user is logged in on the home page

    Scenario: Users can delete planet from the planetarium with valid data input
    # TODO: make sure to use valid planet name in step implementation
        And     the user selects planet from the dropdown
        And     the user provides valid planet name
        And     the user clicks the delete button
        Then    the user should see the updated home page with the planet deleted
    
    Scenario Outline: Users cannot delete planet from the planetarium with invalid data input
        And     the user selects planet from the dropdown
        And     the user provides planet name "<planet name>"
        And     the user clicks the delete button
        Then    the user should get a browser alert saying Invalid planet name
        And     the user should stay on the home page

    Examples:
    |planet name|
    |NotPlanet|