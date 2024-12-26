package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.When;
public class LogoutSteps {

    @When("the user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
        TestRunner.homePage.logout();
    }

}
