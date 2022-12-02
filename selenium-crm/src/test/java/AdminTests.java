import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminTests {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    void setupMethod() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("http://localhost:3000/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @AfterMethod
    void closeWindow() {
//        driver.quit();
    }

    @Test
    void createOpportunity() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div/div[1]/nav/span[2]/a[1]")
        )).click();
        driver.findElement(By.className("newOpportunity")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[name='name']")
        )).sendKeys("Antonio");
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Morillo");
        driver.findElement(By.cssSelector("input[name='nif']")).sendKeys("12345678D");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @Test
    void convertToClient() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div/div[1]/nav/span[2]/a[1]")
        )).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/ul/li[1]/div/button[1]")
        )).click();
    }
}
