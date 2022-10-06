package thefork.testCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import thefork.pages.CommonPage;
import thefork.pages.HomePage;
import thefork.pages.ProfilePage;
import thefork.tools.WebDriverManagement;

public class RunTest {

    WebDriver driver;
    String url = "https://www.thefork.com/";
    String email = "jonathan.qa@yopmail.com";
    String password = "QAchanllenge1";
    String firstName = "jonathan";
    String lastName = "renaud";
    String phoneNumber = "614562588";

    @Before
    public void launchBrowser() {
        driver = WebDriverManagement.webDriverManagement();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void test() {

        CommonPage commonPage = new CommonPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        driver.get(url);

        commonPage.acceptCookies();

        homePage.accessLogin();

        profilePage.login(email,password);

        profilePage.accessToPersonalInfo();

        profilePage.checkPersonalInfo(firstName,lastName,phoneNumber);
    }
}
