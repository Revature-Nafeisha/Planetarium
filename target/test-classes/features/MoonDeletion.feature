@LoggedIn
Feature: Moon Deletion
    As a user I want to remove moons from the Planetarium so I can correct my findings

    Background: Deleting Moon Starting Actions
        Given   the user is logged in on the home page

    Scenario: Users can delete moons from the planetarium with valid data input
    # TODO: make sure to use valid moon name in step implementation 
        And     the user provides valid moon name
        And     the user clicks the delete button
        Then    the user should see the updated home page with the moon deleted

    Scenario Outline: Users cannot delete moons from planetarium with invalid data input
        And     the user provides moon name "<moon name>"
        And     the user clicks the delete button
        Then    the user should get a browser alert saying Invalid moon name
        And     the user should stay on the home page

    Examples:
    |moon name|
    |NotMoon|