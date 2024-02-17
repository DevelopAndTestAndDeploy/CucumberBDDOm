package awsomecucumber.stepDefinitions;

import awsomecucumber.context.TestContext;
import awsomecucumber.domainobjects.BillingDetails;
import awsomecucumber.pages.CartPage;
import awsomecucumber.pages.CheckoutPage;
import awsomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutStepDefinition{

    private TestContext context;

    private final CheckoutPage checkoutPage;

    public CheckoutStepDefinition(TestContext context){
        this.context = context;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }


    @When("I provide billing details")
    public void iProvideBillingDetails()  {
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder()  {
        checkoutPage.placeOrder();

    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() throws InterruptedException {

        Assert.assertEquals("Thank you. Your order has been received.",
                checkoutPage.getNoticeText());

    }


}
