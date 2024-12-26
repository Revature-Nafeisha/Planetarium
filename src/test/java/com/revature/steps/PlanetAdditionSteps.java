package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlanetAdditionSteps {

    @And("the user selects planet from the dropdown")
    public void theUserSelectsPlanetFromTheDropdown() {
        TestRunner.homePage.selectFromDropDown("planet");
    }

    @When("the user provides a valid planet name")
    public void the_user_provides_a_valid_planet_name() {
        TestRunner.homePage.enterPlanetName("Planet name-_-1");
    }

    @When("the user provides a valid file type")
    public void the_user_provides_a_valid_file_type() {
        TestRunner.homePage.enterPlanetImage("C:\\Users\\nafis\\Desktop\\Revature\\Project 1\\Planetarium\\src\\test\\resources\\Celestial-Images\\planets.jpg");
    }
    @When("the user submits the planet data")
    public void the_user_submits_the_planet_data() {
        TestRunner.homePage.clickSubmitButton();
    }

    @Then("the user should see the created planet on home page")
    public void the_user_should_see_the_created_planet_on_home_page() {
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 6));
        Assert.assertEquals(5, TestRunner.homePage.getNumberOfCelestialRows());
    }

    @When("the user provides planet name {string}")
    public void the_user_provides_planet_name(String planet) {
        TestRunner.homePage.enterPlanetName(planet);
    }

    @When("the user provides file type {string}")
    public void the_user_provides_file_type(String image) {
        TestRunner.homePage.enterPlanetImage(image);
    }

}
