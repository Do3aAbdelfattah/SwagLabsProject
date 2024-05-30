package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //elements' locators
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("h3[data-test='error']");

    //elements' actions
    public void enterUsername(String text)
    {
        enterText(usernameField,text);
    }
    public void enterPassword(String text)
    {
        enterText(passwordField,text);
    }
    public void clickOnLoginButton()
    {
        clickOnElement(loginButton);
    }
    public String getErrorMessage()
    {
        return driver.findElement(errorMessage).getText();
    }

}
