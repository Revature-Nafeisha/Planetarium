package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PlanetDeletionSteps {
    @Given("the user provides valid planet name")
    public void the_user_provides_valid_planet_name() {
        TestRunner.homePage.enterDeleteInput("Earth");
    }


    @Then("the user should see the updated home page with the planet deleted")
    public void the_user_should_see_the_updated_home_page_with_the_planet_deleted() {
        //Note: If we delete Earth, both Earth and Luna will be deleted since Luna is "owned" by Earth
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 3));
        List<WebElement> rows = TestRunner.homePage.getRows();
        boolean result = false;
        for(WebElement e : rows)
        {
            if(e.getText().contains("Earth"))
            {
                result = true;
            }
        }
        Assert.assertFalse(result);
//        Assert.assertEquals(2, TestRunner.homePage.getNumberOfCelestialRows());;
    }

    @Then("the user should get a browser alert saying Invalid planet name")
    public void the_user_should_get_a_browser_alert_saying_Invalid_planet_name()
    {
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals("Invalid planet name", alert.getText());
        alert.accept();
    }


}
