package awsomecucumber.context;

import awsomecucumber.domainobjects.BillingDetails;
import awsomecucumber.domainobjects.Cookies;
import org.openqa.selenium.WebDriver;

public class TestContext {

    public WebDriver driver;
    public BillingDetails billingDetails;

    public Cookies cookies;

    public TestContext(){
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
    }




}
