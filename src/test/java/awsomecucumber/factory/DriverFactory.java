package awsomecucumber.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser){
            case "chrome" :
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("INVALID BROWSER " + browser);

        }
        driver.manage().window().maximize();
        return driver;
    }





}
