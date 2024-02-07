package awsomecucumber;

import awsomecucumber.factory.DriverFactory;
import awsomecucumber.pages.CartPage;
import awsomecucumber.pages.CheckoutPage;
import awsomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyStepDefinitions {

    private WebDriver driver;

    @Given("I am on the store page")
    public void i_am_on_the_store_page() {

        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store");

    }
    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String productName)  {
        new StorePage(driver).addToCart(productName);
    }
    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(int quantity, String productName) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(productName, cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());

    }

//new steps
    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {

        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store");
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart()  {
        new StorePage(driver).addToCart("Blue Shoes");

    }

    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        new CartPage(driver).checkout();
    }

    @When("I provide billing details")
    public void iProvideBillingDetails(List<Map<String , String>> billingDetails) {
       CheckoutPage checkoutPage = new CheckoutPage(driver);
       checkoutPage.setBillingDetails(billingDetails.get(0).get("firstname"),
               billingDetails.get(0).get("lastname"),
               billingDetails.get(0).get("address_line1"),
               billingDetails.get(0).get("city"),
               billingDetails.get(0).get("state"),
               billingDetails.get(0).get("zip"),
               billingDetails.get(0).get("email"));
    }

    @And("I place an order")
    public void iPlaceAnOrder()  {
        new CheckoutPage(driver).placeOrder();

    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() throws InterruptedException {

        Assert.assertEquals("Thank you. Your order has been received.",
                new CheckoutPage(driver).getNoticeText());

    }
}
