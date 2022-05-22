package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBlock extends BaseView {
    public NavigationBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li/a[@title='Women']")
    public WebElement buttonWomenTopMenu;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li/a[@title='Dresses']")
    public WebElement buttonDressesTopMenu;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li/a[@title='T-shirts']")
   public WebElement buttonTShirtsTopMenu;

    public DressesPage jumpToDressesPage() {
        buttonDressesTopMenu.click();
        return new DressesPage(driver);
    }

    public TShirtsPage jumpToTShirtsPage() {
        buttonTShirtsTopMenu.click();
        return new TShirtsPage(driver);
    }

    public WomenPage jumpWomenPage() {
        buttonWomenTopMenu.click();
        return new WomenPage(driver);
    }
}
