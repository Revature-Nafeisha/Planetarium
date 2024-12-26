Feature: Logging out

    Scenario: Users can logout when logged in
        Given   the user is logged in on the home page
        When    the user clicks the logout button
        Then    the user should be redirected to the login page

    Scenario: Users cannot logout when not logged in
        Given   the user is not logged in
        Then    the user should stay on the login page