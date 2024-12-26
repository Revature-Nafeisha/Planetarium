package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;

    @FindBy(tagName = "select")
    private WebElement dropdown;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetNameInput; //planetID

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(id = "moonImageInput")
    private WebElement moonFile;

    @FindBy(xpath = "//*[@class='submit-button']")
    private WebElement submitButton;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetFile;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows(){
        return tableRows.size()-1;
    }

    public void tryToAccessHomePageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public void logout(){
        logoutButton.click();
    }

    public void selectFromDropDown(String value)
    {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public void enterMoonName(String moonName)
    {
        moonNameInput.sendKeys(moonName);
    }

    public void enterOrbitedPlanetName(String orbitedPlanetName)
    {
        orbitedPlanetNameInput.sendKeys(orbitedPlanetName);
    }
    //TODO: complete uploading the file
    public void enterMoonImage(String image)
    {
        //moonFile.sendKeys(image);
    }
    public void clickSubmitButton()
    {
        submitButton.click();
    }
    public void enterDeleteInput(String delete)
    {
        deleteInput.sendKeys(delete);
    }
    public void clickDeleteButton()
    {
        deleteButton.click();
    }
    public void enterPlanetName(String planetName)
    {
        planetNameInput.sendKeys(planetName);
    }
    public void enterPlanetImage(String image)
    {
        planetFile.sendKeys(image);
    }
    public List<WebElement> getRows()
    {
        return tableRows;
    }


}
