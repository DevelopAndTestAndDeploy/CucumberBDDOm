package awsomecucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.TreeMap;

public class MyStepDefinitions {

    private WebDriver driver;

    @Given("I am on the store page")
    public void i_am_on_the_store_page() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store");
       
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
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
    }
}
