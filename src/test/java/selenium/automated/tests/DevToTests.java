package selenium.automated.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class DevToTests {

    WebDriver driver;

    @Before
    public void SetUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SDA dokumenty\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void FirstTest() {

        String URL = "https://dev.to/";
        driver.get(URL);

        String currentUrl = driver.getCurrentUrl();
        assertTrue("The current URL isn't dev.to", URL.equals(currentUrl));

    }



}
