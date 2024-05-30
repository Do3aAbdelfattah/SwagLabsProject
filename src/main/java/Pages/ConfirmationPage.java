package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends PageBase{
    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }
    By thankyouMessage = By.className("complete-header");
    public String getThankyouMessage()
    {
        return driver.findElement(thankyouMessage).getText();
    }
}
