package thefork.tools;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class CommonActions {

    public static void type(WebElement input, String text){
        input.click();
        input.clear();
        input.sendKeys(text);
    }

    public static void checkInput(WebElement input){
        Assert.assertTrue(input.isDisplayed() && input.isEnabled());
    }

    public static void clickButton(WebElement button){
        Assert.assertTrue(button.isEnabled());
        button.click();
    }

    public static void checkValue(WebElement element, String attribute, String value_expected){
        String actual_value = element.getAttribute(attribute).toLowerCase();
        Assert.assertEquals(value_expected.toLowerCase(),actual_value);
    }
}
