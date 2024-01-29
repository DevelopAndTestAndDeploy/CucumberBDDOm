package awsomecucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepDefinitions {

    @Given("I am on the store page")
    public void i_am_on_the_store_page() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store");
    }
    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String string) {
       
    }
    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(Integer int1, String string) {
       
    }


}
