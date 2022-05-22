package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DressesPage extends BaseView {
    public DressesPage(WebDriver driver) {
        super(driver);
        navigationBlock = new NavigationBlock(driver);
    }

    public NavigationBlock navigationBlock;

    @FindBy(xpath = "//a[@title='Add to cart']")
    public List<WebElement> dressesAddToCart;


    public SuccessBlock addToCartProduct(int indexNumber) {
        dressesAddToCart.get(indexNumber % dressesAddToCart.size()).click();
        return new SuccessBlock(driver);
    }

    public TShirtsPage jumpToTShirtsPage() {
        return navigationBlock.jumpToTShirtsPage();
    }

}
