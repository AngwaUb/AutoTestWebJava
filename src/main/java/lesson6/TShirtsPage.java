package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TShirtsPage extends BaseView {
    public TShirtsPage(WebDriver driver) {
        super(driver);
        navigationBlock = new NavigationBlock(driver);
    }

    public NavigationBlock navigationBlock;

    @FindBy(xpath = "//a[@title='Add to cart']")
    public List<WebElement> tShirtsAddToCart;


    public SuccessBlock addToCartProduct(int indexNumber) {
        tShirtsAddToCart.get(indexNumber % tShirtsAddToCart.size()).click();
        return new SuccessBlock(driver);
    }

}
