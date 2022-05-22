package lesson6;

import org.openqa.selenium.WebDriver;

public class StartPage extends BaseView {
    public StartPage(WebDriver driver) {
        super(driver);
        navigationBlock = new NavigationBlock(driver);
    }

    public NavigationBlock navigationBlock;

    public DressesPage jumpToDressesPage() {
        return navigationBlock.jumpToDressesPage();
    }

    public WomenPage jumpToWomenPage() {
        return navigationBlock.jumpWomenPage();
    }
}
