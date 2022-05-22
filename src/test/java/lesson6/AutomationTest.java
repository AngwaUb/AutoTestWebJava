package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomationTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    void addingAndRemovingItemsToCartUnauthorizedUser() {
        driver.get("http://automationpractice.com/index.php");
        new StartPage(driver)
                .jumpToWomenPage()
                .addToCartProduct(1)
                .continueShoppingToWomen()
                .jumpToDressesPage()
                .addToCartProduct(5)
                .continueShoppingToDressing()
                .jumpToTShirtsPage()
                .addToCartProduct(1)
                .proceedToCheckout();
        Assertions.assertEquals(driver.findElements(By.className("cart_item")).size(), 3);
        new CartPage(driver)
                .removeAll()
                .waitUntilRemoveComplete();
        Assertions.assertTrue(driver.findElement(By.xpath("//p[text()='Your shopping cart is empty.']")).isDisplayed());
    }


    @Test
    void purchaseUnauthorizedUserTest() {
        driver.get("http://automationpractice.com/index.php");
        new StartPage(driver)
                .jumpToDressesPage()
                .addToCartProduct(2)
                .continueShoppingToDressing()
                .addToCartProduct(5)
                .proceedToCheckout()
                .proceedToCheckoutFromCart();

        Assertions.assertTrue(driver.findElement(By.id("email_create")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
