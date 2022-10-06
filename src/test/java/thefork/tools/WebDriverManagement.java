package thefork.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverManagement {
    static WebDriver driver;

    public static WebDriver webDriverManagement(){
        String webDriverPath;

        if(System.getProperties().get("os").toString().equals("windows"))
            webDriverPath = "src/test/drivers/windows/chromedriver.exe";
         else
            webDriverPath = "src/test/drivers/mac/chromedriver";

        System.setProperty("webdriver.chrome.driver",webDriverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        return driver;
    }
}
