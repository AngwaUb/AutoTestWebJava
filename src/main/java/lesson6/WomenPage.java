package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WomenPage extends BaseView {
    public WomenPage(WebDriver driver) {
        super(driver);
        navigationBlock = new NavigationBlock(driver);
    }

    public NavigationBlock navigationBlock;
    @FindBy(xpath = "//a[@title='Add to cart']")
    public List<WebElement> womenAddToCart;


    public SuccessBlock addToCartProduct(int indexNumber) {
        womenAddToCart.get(indexNumber % womenAddToCart.size()).click();
        return new SuccessBlock(driver);
    }

    public DressesPage jumpToDressesPage() {
        return navigationBlock.jumpToDressesPage();
    }
}

