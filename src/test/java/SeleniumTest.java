import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class SeleniumTest {

    public static ChromeOptions options;
    public static WebDriver driver ;
    @BeforeTest

    public static void Setup(){

        options = new ChromeOptions();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") +"/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);

        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");

    }

    @Test
    void testSteps() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"menuToggle\"]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]/li")).click();

        driver.findElement(By.xpath("//*[@id=\"usr\"]")).sendKeys("Ria");

        driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("1234");

        driver.findElement(By.xpath("//*[@id=\"second_form\"]/input")).click();

        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"ShoeType\"]"));

        String actualFirstCategory = webElement.getText();

        String expectedFirstCategory = "Formal Shoes";

        Assert.assertEquals(expectedFirstCategory, actualFirstCategory);

        driver.close();



    }
}
