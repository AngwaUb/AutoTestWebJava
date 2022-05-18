package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomeWork5Test {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    void addingAndRemovingItemsToCartUnauthorizedUser() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li/a[@title='Women']")).click();
        driver.findElement(By.xpath("//a[@data-id-product='2']/span")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Continue shopping']/span")));
        driver.findElement(By.xpath("//span[@title='Continue shopping']/span")).click();

        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li/a[@title='Dresses']")).click();

        driver.findElement(By.xpath("//a[@data-id-product= '7']/span")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Continue shopping']/span")));
        driver.findElement(By.xpath("//span[@title='Continue shopping']/span")).click();

        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li/a[@title='T-shirts']")).click();

        driver.findElement(By.xpath("//a[@data-id-product= '1']/span")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']/span")));
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']/span")).click();

        Assertions.assertEquals(driver.findElements(By.className("cart_item")).size(), 3);

        //тест у меня успешен только в таком виде: с тремя "плохими" ожиданиями, с "хорошими" - фэйлится. Не знаю причины и не знаю, как сделать правильно
        driver.findElement(By.className("icon-trash")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("icon-trash")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("icon-trash")).click();

        Thread.sleep(5000);

        Assertions.assertTrue(driver.findElement(By.xpath("//p[text()='Your shopping cart is empty.']")).isDisplayed());
    }


    @Test
    void purchaseUnauthorizedUser() {
        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li/a[@title='Dresses']")).click();
        driver.findElement(By.xpath("//a[@data-id-product='4']/span")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Continue shopping']/span")));
        driver.findElement(By.xpath("//span[@title='Continue shopping']/span")).click();

        driver.findElement(By.xpath("//a[@data-id-product= '7']/span")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']/span")));
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']/span")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Proceed to checkout']")));
        driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();

        Assertions.assertEquals(driver.findElement(By.id("email_create")).isDisplayed(), true);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}
