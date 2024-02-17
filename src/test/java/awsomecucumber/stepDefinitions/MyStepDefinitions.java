package awsomecucumber.stepDefinitions;

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


    public MyStepDefinitions(TestContext context){
        driver = context.driver;
    }






//new steps








}
