package thefork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {

    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver=driver;
    }


    // -- OBJECTS

    By cookie_banner = By.id("_evidon_banner");

    By accept_cookie_button = By.id("_evidon-accept-button");


    // -- METHODS

    public void acceptCookies(){
        if(driver.findElement(cookie_banner).isDisplayed())
            driver.findElement(accept_cookie_button).click();
    }

}
