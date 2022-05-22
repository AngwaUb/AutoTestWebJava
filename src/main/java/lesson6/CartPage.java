package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BaseView {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    private WebElement buttonProceedToCheckout;

    @FindBy(className = "icon-trash")
    public List<WebElement> iconTrash;

    public LoginPage proceedToCheckoutFromCart() {
        buttonProceedToCheckout.click();
        return new LoginPage(driver);
    }

   public CartPage removeAll() {
        iconTrash.forEach((elem) -> elem.click());
        return new CartPage(driver);
   }

   public void waitUntilRemoveComplete() {
       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Your shopping cart is empty.']")));
   }

}
