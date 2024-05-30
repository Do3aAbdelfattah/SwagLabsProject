package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends PageBase{
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }
    By FinishButton = By.className("cart_button");

    public void clickOnFinishButton()
    {
        clickOnElement(FinishButton);
    }
}
