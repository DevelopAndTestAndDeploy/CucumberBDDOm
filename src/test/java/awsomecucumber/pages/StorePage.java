package awsomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StorePage extends BasePage{


    @FindBy(css = "a[title='View cart']")
    private WebElement viewCartLink;

    @FindBy(xpath = "//h1[normalize-space()='Store']")
    private WebElement titleText;
    public StorePage(WebDriver driver) {
        super (driver);
    }


    public void addToCart(String productName){
        By addToCartBtn = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        wait.until(ExpectedConditions.visibilityOf(titleText));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
}
