/* Zadanie:
1. Wejdź na https://interviewme.pl/kreator-cv
2. Wybierz szablon CV
3. Napisz swoje CV
4. Uzupełnij wszystkie dane
5. Na ostatniej stronie oczkekuj informacji: "Gratulacje, Twoje CV jest gotowe!" */


package selenium.automated.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CVformularzTests {

    WebDriver driver;
    String URL = "https://interviewme.pl/kreator-cv";

    @Before
    public void SetUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SDA dokumenty\\SeleniumDrivers\\chromedriver.exe"); //ścieżka do chrome drivera
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void CVcreator() {


        }


}
