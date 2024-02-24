package awsomecucumber.stepDefinitions;

import awsomecucumber.apis.CartApi;
import awsomecucumber.constants.EndPoint;
import awsomecucumber.context.TestContext;
import awsomecucumber.domainobjects.BillingDetails;
import awsomecucumber.domainobjects.Product;
import awsomecucumber.pages.PageFactoryManager;
import awsomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StoreStepDefinition {

    private final StorePage storePage;
    private final TestContext context;

    public StoreStepDefinition(TestContext context){
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I am on the store page")
    public void i_am_on_the_store_page() {

        storePage.load(EndPoint.STORE.url);

    }

    @When("I add {product} to the cart")
    public void i_add_to_the_cart(Product product)  {

        storePage.addToCart(product.getName()   );
    }


    @And("I have a product in the cart")
    public void iHaveAProductInTheCart()  {
        //storePage.addToCart("Blue Shoes");
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215, 1);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);

    }
}
