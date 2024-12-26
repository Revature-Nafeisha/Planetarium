package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MoonAdditionSteps
{
    //Happy Path

    @And("the user selects moon from the dropdown")
    public void theUserSelectsMoonFromTheDropdown() {
        TestRunner.homePage.selectFromDropDown("moon");
    }

    @When("the user provides a valid moon name")
    public void the_user_provides_a_valid_moon_name() {
        TestRunner.homePage.enterMoonName("Moon name-_-1");
    }

    @When("the user provides a valid planet ID")
    public void the_user_provides_a_valid_planet_ID() {
        TestRunner.homePage.enterOrbitedPlanetName("1");
    }
    @When("the user submits the moon data")
    public void the_user_submits_the_moon_data() {
        TestRunner.homePage.clickSubmitButton();
    }

    @Then("the user should see the created moon on home page")
    public void the_user_should_see_the_created_moon_on_home_page() {
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 6));
//        Assert.assertEquals(4, TestRunner.homePage.getNumberOfCelestialRows());
        Assert.assertEquals(5, TestRunner.homePage.getNumberOfCelestialRows());
        //TestRunner.homePage.logout(); fixed with hooks to log out: see Hooks for detail
        //TODO:fix to see the actual element
    }

    @When("the user provides moon name {string}")
    public void the_user_provides_moon_name(String moonName) {
        TestRunner.homePage.enterMoonName(moonName);
    }

    //Sad Path

    @When("the user provides planet ID {string}")
    public void the_user_provides_planet_ID(String planetId) {
        TestRunner.homePage.enterOrbitedPlanetName(planetId);
    }

    @Then("the user should stay on the home page")
    public void the_user_should_stay_on_the_home_page() {
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }


}
