package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessBlock extends BaseView {
    public SuccessBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@title='Continue shopping']/span")
    public WebElement buttonContinueShopping;

    @FindBy(xpath = "//a[@title='Proceed to checkout']/span")
    public WebElement buttonProceedToCheckout;

    public CartPage proceedToCheckout() {
        webDriverWait.until(ExpectedConditions.visibilityOf(buttonProceedToCheckout));
        buttonProceedToCheckout.click();
        return new CartPage(driver);
    }

    public DressesPage continueShoppingToDressing() {
        webDriverWait.until(ExpectedConditions.visibilityOf(buttonContinueShopping));
        buttonContinueShopping.click();
        return new DressesPage(driver);
    }

    public WomenPage continueShoppingToWomen() {
        webDriverWait.until(ExpectedConditions.visibilityOf(buttonContinueShopping));
        buttonContinueShopping.click();
        return new WomenPage(driver);
    }
}
