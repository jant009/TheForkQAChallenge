package thefork.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import thefork.tools.CommonActions;

public class ProfilePage {
    WebDriver driver;


    public ProfilePage(WebDriver driver) {
        this.driver=driver;
    }


    // -- OBJECTS

    By email_login_input = By.xpath("//input[@data-testid='checkout-email-input']");

    By submit_login_btn = By.xpath("//button[@data-testid='checkout-submit-email']");

    By password_login_input = By.xpath("//input[@data-testid='password-input']");

    By submit_password_btn = By.xpath("//button[@data-testid='submit-password']");

    By user_section = By.id("USER_SPACE_FIRST_PANEL");

    By user_personal_info_btn = By.xpath("//button[@aria-controls='user-space-user-information']");

    By user_personal_info_container = By.id("USER_SPACE_SECOND_PANEL");

    By user_personal_info_firstname = By.name("firstName");

    By user_personal_info_lastName = By.name("lastName");

    By user_personal_info_phoneNumber = By.name("phoneNumber.nationalNumber");

    // -- METHODS


    public void login(String email_user, String password){
        //set and submit login/email
        CommonActions.checkInput(driver.findElement(email_login_input));
        CommonActions.type(driver.findElement(email_login_input),email_user);
        CommonActions.clickButton(driver.findElement(submit_login_btn));

        //set and submit password
        CommonActions.checkInput(driver.findElement(password_login_input));
        CommonActions.type(driver.findElement(password_login_input),password);
        CommonActions.clickButton(driver.findElement(submit_password_btn));

        Assert.assertTrue(driver.findElement(user_section).isDisplayed());
    }

    public void accessToPersonalInfo(){
        CommonActions.clickButton(driver.findElement(user_personal_info_btn));
        Assert.assertTrue(driver.findElement(user_personal_info_container).isDisplayed());
    }
    public void checkPersonnalInfo(String firstName, String lastName, String phoneNumber){
        CommonActions.checkValue(driver.findElement(user_personal_info_firstname),"value",firstName);
        CommonActions.checkValue(driver.findElement(user_personal_info_lastName),"value",lastName);
        CommonActions.checkValue(driver.findElement(user_personal_info_phoneNumber),"value",phoneNumber);
    }

}
