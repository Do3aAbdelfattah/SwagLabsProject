package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    By AddtoCartButton = By.xpath("//button[@class='btn_primary btn_inventory']");
    By CartIcon = By.cssSelector("svg[data-icon='shopping-cart']");

    public void clickOnAddtoCartButton()
    {
        //click on add to cart button of the first item
        driver.findElements(AddtoCartButton).get(0).click();
    }
    public void clickOnCartIcon()
    {
        clickOnElement(CartIcon);
    }
}
