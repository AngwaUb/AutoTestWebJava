package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxdriver = new FirefoxDriver();
        firefoxdriver.get("https://ya.ru");
        Thread.sleep(5000);
        firefoxdriver.quit();
        driver.quit();
    }
}
