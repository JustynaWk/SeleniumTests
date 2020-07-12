package selenium.automated.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2_wowPageTest {

    WebDriver driver;
    String tekst = "Archena";
    String URL = "https://worldofwarcraft.com/en-gb/";
    String ExpectedURL = "https://worldofwarcraft.com/en-gb/";

    @Before
            public void SetUp() {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SDA dokumenty\\SeleniumDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(URL);
    }

    @Test
            public void Test_1() {

            WebElement LatedNews = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/div[6]/div[2]/a"));
            LatedNews.click();

            WebDriverWait wait= new WebDriverWait(driver,10); //oczekiwanie
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[2]/div[1]/div/a")));
            WebElement NewsRoundUp = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[2]/div[1]/div/a"));
            NewsRoundUp.click();

            WebDriverWait wait2= new WebDriverWait(driver,10); //oczekiwanie
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/nav/div/div/div/div[1]/div/div[2]/div/div[1]/a")));
            WebElement SearchField = driver.findElement(By.xpath("/html/body/div[3]/div/nav/div/div/div/div[1]/div/div[2]/div/div[1]/a"));
            SearchField.click();

            WebElement SearchTextArea = driver.findElement(By.id("searchInput"));
            SearchTextArea.sendKeys(tekst);
            SearchTextArea.submit();

            WebDriverWait wait3= new WebDriverWait(driver,10); //oczekiwanie
            wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div/div[5]/div/div/div[3]/div[4]/a/div/div/div[2]/div/div")));
            WebElement Character = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div/div[5]/div/div/div[3]/div[4]/a/div/div/div[2]/div/div"));
            Character.click();

            WebDriverWait wait4= new WebDriverWait(driver,10); //oczekiwanie
            wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/nav/div/div/div/div[1]/div/a/div[1]")));
            WebElement Back = driver.findElement(By.xpath("/html/body/div[3]/div/nav/div/div/div/div[1]/div/a/div[1]"));
            Back.click();

            WebDriverWait wait5= new WebDriverWait(driver,10); //oczekiwanie
            wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/nav/div/div/div/div[1]/div/a/div[1]")));
            Assert.assertEquals(URL, ExpectedURL);
            Assert.assertNotEquals(ExpectedURL, "Coś jednak nie wyszło, kombinujmy dalej.");
    }
        @After
            public void Closing () {

            driver.quit();
            System.out.println("Test przebiegł pomyślnie, gratulacje!");


        }


}
