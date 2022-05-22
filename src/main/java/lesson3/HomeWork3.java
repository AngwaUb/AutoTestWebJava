package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Тест "Покупка неавторизованным пользователем.
public class HomeWork3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id='center_column']/ul/li[2]/div/div[2]/div[2]/a[1]/span")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")));
        driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")).click();

        driver.findElement(By.xpath("//*[@id='center_column']/ul/li[5]/div/div[2]/div[2]/a[1]/span")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")));
        driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")));
        driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
