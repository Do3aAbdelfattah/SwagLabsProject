package steps;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static base.TestBase.driver;

public class LoginFunctionalitySteps {

    LoginPage LoginPageObject = new LoginPage(driver);
    HomePage HomePageObject = new HomePage(driver);
    CartPage cartPageObject = new CartPage(driver);
    UserInformationPage UserInformationPageObject = new UserInformationPage(driver);
    CheckoutOverviewPage CheckoutOverviewPageObject = new CheckoutOverviewPage(driver);
    ConfirmationPage ConfirmationPageObject = new ConfirmationPage(driver);
    String LoginPageURL = "https://www.saucedemo.com/v1/index.html";
    String HomePageURL = "https://www.saucedemo.com/v1/inventory.html";
    String CartPageURL = "https://www.saucedemo.com/v1/cart.html";
    String UserInformationPageURL = "https://www.saucedemo.com/v1/checkout-step-one.html";
    String CheckoutOverviewPageURL = "https://www.saucedemo.com/v1/checkout-step-two.html";
    String ConfirmationPageURL = "https://www.saucedemo.com/v1/checkout-complete.html";

    @Given("user is in login page")
    public void user_is_in_login_page() {
        //assert that user is in login page
        Assert.assertEquals(driver.getCurrentUrl(),LoginPageURL, "User is not in login page.");
    }
    @When("user enters username {string}")
    public void user_enters_username(String username) {
        LoginPageObject.enterUsername(username);
    }
    @And("user enters password {string}")
    public void user_enters_password(String password) {
        LoginPageObject.enterPassword(password);
    }
    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        LoginPageObject.clickOnLoginButton();
    }
    @Then("user is redirected to the home page")
    public void user_is_redirected_to_the_home_page() {
        //assert that home page is opened
        Assert.assertEquals(driver.getCurrentUrl(),HomePageURL, "Home page isn't opened.");
    }
    @When("user adds an item to cart")
    public void userAddsAnItemToCart() {
        HomePageObject.clickOnAddtoCartButton();
    }
    @And("user clicks on cart icon")
    public void userClicksOnCartIcon() {
        HomePageObject.clickOnCartIcon();
    }
    @Then("cart page is opened")
    public void cartPageIsOpened() {
        //assert that cart page is opened
        Assert.assertEquals(driver.getCurrentUrl(),CartPageURL,"cart page isn't opened.");
    }
    @When("user clicks on checkout button")
    public void userClicksOnCheckoutButton() {
        cartPageObject.clickOnCheckoutButton();
    }
    @Then("user is redirected to the user information page")
    public void userIsRedirectedToTheUserInformationPage() {
        //assert that user information page is opened
        Assert.assertEquals(driver.getCurrentUrl(),UserInformationPageURL,"user information page isn't opened.");
    }
    @When("user enters first name {string}")
    public void userEntersFirstName(String firstname) {
        UserInformationPageObject.enterFirstName(firstname);
    }
    @And("user enters last name {string}")
    public void userEntersLastName(String lastname) {
        UserInformationPageObject.enterLastName(lastname);
    }
    @And("user enters zipcode {string}")
    public void userEntersZipcode(String zipcode) {
        UserInformationPageObject.enterZipCode(zipcode);
    }
    @And("user clicks on continue button")
    public void userClicksOnContinueButton() {
        UserInformationPageObject.clickOnContinueButton();
    }
    @Then("checkout overview page is opened")
    public void checkoutOverviewPageIsOpened() {
        //assert that checkout overview page is opened
        Assert.assertEquals(driver.getCurrentUrl(), CheckoutOverviewPageURL, "checkout overview page isn't opened.");
    }
    @When("user clicks on finish button")
    public void userClicksOnFinishButton() {
        CheckoutOverviewPageObject.clickOnFinishButton();
    }
    @Then("confirmation page is displayed with thank you message")
    public void confirmationPageIsDisplayedWithThankYouMessage() {
        //assert that confirmation page is opened
        Assert.assertEquals(driver.getCurrentUrl(),ConfirmationPageURL, "Confirmation page isn't opened.");

        //assert that thank you message displayed
        Assert.assertEquals(ConfirmationPageObject.getThankyouMessage(),"THANK YOU FOR YOUR ORDER", "displayed confirmation message isn't correct");
    }
    @Then("user can't login and error message displayed")
    public void userCanTLoginAndErrorMessageDisplayed() {
        //assert that user is't redirected to home page
        Assert.assertNotEquals(driver.getCurrentUrl(),HomePageURL, "system redirected to home page.");

        //assert that an error message displayed
        String displayedMessage = LoginPageObject.getErrorMessage();
        Assert.assertTrue(displayedMessage.contains("Username and password do not match any user"),"The displayed error message does not contain the expected text.");
    }
}
