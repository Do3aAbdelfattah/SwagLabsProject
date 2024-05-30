package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInformationPage extends PageBase{
    public UserInformationPage(WebDriver driver) {
        super(driver);
    }
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipCodeField = By.id("postal-code");
    By continueButton = By.cssSelector("[value='CONTINUE']");

    public void enterFirstName(String text)
    {
        enterText(firstNameField,text);
    }
    public void enterLastName(String text)
    {
        enterText(lastNameField,text);
    }
    public void enterZipCode(String text)
    {
        enterText(zipCodeField,text);
    }
    public void clickOnContinueButton()
    {
        clickOnElement(continueButton);
    }


}
