package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    By checkoutButton = By.className("checkout_button");

    public void clickOnCheckoutButton()
    {
        clickOnElement(checkoutButton);
    }
}
