package awsomecucumber;

import awsomecucumber.constants.EndPoint;
import awsomecucumber.context.TestContext;
import awsomecucumber.domainobjects.BillingDetails;
import awsomecucumber.domainobjects.Product;
import awsomecucumber.factory.DriverFactory;
import awsomecucumber.pages.CartPage;
import awsomecucumber.pages.CheckoutPage;
import awsomecucumber.pages.StorePage;
import awsomecucumber.utils.ConfigLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyStepDefinitions {

    private final WebDriver driver;
    private BillingDetails billingDetails;


    public MyStepDefinitions(TestContext context){
        driver = context.driver;
    }

    @Given("I am on the store page")
    public void i_am_on_the_store_page() {

        new StorePage(driver).load(EndPoint.STORE.url);

    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    @When("I add {product} to the cart")
    public void i_add_to_the_cart(Product product)  {

        new StorePage(driver).addToCart(product.getName()   );
    }
    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(int quantity, Product product) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());

    }

//new steps
    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {

        new StorePage(driver).load(EndPoint.STORE.url);
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
    public void iProvideBillingDetails()  {
       CheckoutPage checkoutPage = new CheckoutPage(driver);
       checkoutPage.setBillingDetails(billingDetails);
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
