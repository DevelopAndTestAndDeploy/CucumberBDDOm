package awsomecucumber.stepDefinitions;

import awsomecucumber.context.TestContext;
import awsomecucumber.domainobjects.Product;
import awsomecucumber.pages.CartPage;
import awsomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStepDefinition {

    private final CartPage cartPage;

    public CartStepDefinition(TestContext context){
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }


    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {

        cartPage.checkout();
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(int quantity, Product product) {

        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());

    }
}
