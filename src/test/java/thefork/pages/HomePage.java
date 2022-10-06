package thefork.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import thefork.tools.CommonActions;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    // -- OBJECTS

    By login_btn = By.xpath("//button[@data-testid='user-space']");

    By section_login = By.id("USER_SPACE_FIRST_PANEL");


    // -- METHODS

    public void accessLogin(){
        CommonActions.clickButton(driver.findElement(login_btn));
        Assert.assertTrue(driver.findElement(section_login).isDisplayed());
    }

}
