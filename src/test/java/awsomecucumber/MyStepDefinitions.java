package awsomecucumber;

import awsomecucumber.factory.DriverFactory;
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
        driver.get("https://askomdch.com/store");
        System.out.println("adaaff");
       
    }
    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String productName) throws InterruptedException {
        By addToCartBtn = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        driver.findElement(addToCartBtn).click();
        Thread.sleep(3000);
        By viewCartLink = By.cssSelector("a[title='View cart']");
        driver.findElement(viewCartLink).click();
    }
    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(int quantity, String productName) {
        By productNameFld = By.cssSelector("td[class='product-name'] a");
        String actualProductName = driver.findElement(productNameFld).getText();
        By productQuantityFld = By.cssSelector("input[type=\"number\"]");
        String actualQuantity = driver.findElement(productQuantityFld).getAttribute("value");
        Assert.assertEquals(productName, actualProductName);
        Assert.assertEquals(quantity, Integer.parseInt(actualQuantity));

    }

//new steps
    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {

        driver = DriverFactory.getDriver();
        driver.get("https://askomdch.com/store");
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
        driver.get("https://askomdch.com/store");
        By addToCartBtn = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
        driver.findElement(addToCartBtn).click();
        Thread.sleep(3000);
        By viewCartLink = By.cssSelector("a[title='View cart']");
        driver.findElement(viewCartLink).click();
    }

    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        By proceedToCheckoutBtn = By.cssSelector(".checkout-button");
        driver.findElement(proceedToCheckoutBtn).click();
    }

    @When("I provide billing details")
    public void iProvideBillingDetails(List<Map<String , String>> billingDetails) {
        By billingFirstNameFld = By.id("billing_first_name");
        By billingLastNameFld = By.id("billing_last_name");
        By billingAddressOneFld = By.id("billing_address_1");
        By billingCityFld = By.id("billing_city");
        By billingStateDropDown = By.id("billing_state");
        By billingZipFld = By.id("billing_postcode");
        By billingEmailFld = By.id("billing_email");

        driver.findElement(billingFirstNameFld).clear();
        driver.findElement(billingFirstNameFld).sendKeys(billingDetails.get(0).get("firstname"));
        driver.findElement(billingLastNameFld).clear();
        driver.findElement(billingLastNameFld).sendKeys(billingDetails.get(0).get("lastname"));
        driver.findElement(billingAddressOneFld).clear();
        driver.findElement(billingAddressOneFld).sendKeys(billingDetails.get(0).get("address_line1"));
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(billingDetails.get(0).get("city"));
        Select select = new Select(driver.findElement(billingStateDropDown));
        select.selectByVisibleText(billingDetails.get(0).get("state"));
        driver.findElement(billingZipFld).clear();
        driver.findElement(billingZipFld).sendKeys(billingDetails.get(0).get("zip"));
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(billingDetails.get(0).get("email"));
    }

    @And("I place an order")
    public void iPlaceAnOrder() throws InterruptedException {
        By placeOrderBtn = By.id("place_order");
        driver.findElement(placeOrderBtn).click();
        Thread.sleep(5000);

    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() throws InterruptedException {
        By noticeTxt = By.cssSelector(".woocommerce-notice");
        String actualNoticeMsg = driver.findElement(noticeTxt).getText();
        Assert.assertEquals("Thank you. Your order has been received.", actualNoticeMsg);

    }
}
