package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps {
    @When("the user provides an existing username")
    public void the_user_provides_an_existing_username() {
        TestRunner.loginPage.enterUsername("Batman");
    }

    @When("the user provides the correct password")
    public void the_user_provides_the_correct_password() {
        TestRunner.loginPage.enterPassword("Iamthenight1939");
    }
    @When("the user submits the credentials for log in")
    public void the_user_submits_the_credentials_for_log_in() {
        TestRunner.loginPage.clickLoginButton();
    }
    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() throws InterruptedException {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Planetarium Login")));
        //TestRunner.wait.wait(10000);
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }

    @When("the user provides username {string} for log in")
    public void the_user_provides_username_for_log_in(String username) {
        TestRunner.loginPage.enterUsername(username);
    }

    @When("the user provides password {string} for log in")
    public void the_user_provides_password_for_log_in(String password) {
        TestRunner.loginPage.enterPassword(password);
    }
    @Then("the user should get a browser alert saying Invalid credentials")
    public void the_user_should_get_a_browser_alert_saying_Invalid_credentials() {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals("Invalid credentials", alert.getText());
        alert.accept();
    }
    @Then("the user should stay on the login page")
    public void the_user_should_stay_on_the_login_page() {
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }


}
