package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MoonDeletionSteps {

    @When("the user provides valid moon name")
    public void the_user_provides_valid_moon_name() {
        TestRunner.homePage.enterDeleteInput("Luna");
    }
    @When("the user clicks the delete button")
    public void the_user_clicks_the_delete_button() {
        TestRunner.homePage.clickDeleteButton();
    }
    @Then("the user should see the updated home page with the moon deleted")
    public void the_user_should_see_the_updated_home_page_with_the_moon_deleted() {
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 4));
        List<WebElement> rows = TestRunner.homePage.getRows();
        boolean result = false;
        for(WebElement e : rows)
        {
            if(e.getText().contains("Luna"))
            {
                result = true;
            }
        }
        Assert.assertFalse(result);
//        Assert.assertEquals(3, TestRunner.homePage.getNumberOfCelestialRows());
    }

    @Then("the user should get a browser alert saying Invalid moon name")
    public void theUserShouldGetABrowserAlertSayingInvalidMoonName() {
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals("Invalid moon name", alert.getText());
        alert.accept();
    }
}
