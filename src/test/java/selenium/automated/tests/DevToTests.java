package selenium.automated.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class DevToTests {

    WebDriver driver;                   //pusta przeglądarka

    @Before
    public void SetUp() {                 //metoda set-up odnosi się do Before - warunki początkowe

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SDA dokumenty\\SeleniumDrivers\\chromedriver.exe"); //ścieżka do chrome drivera
        driver = new ChromeDriver();       //zdefiniowanie przeglądarki jako chrome
    }

    @Test
    public void FirstTest() {

        String URL = "https://dev.to/";     //link, ktory ma byc otwarty
        driver.get(URL);                    // otworzenie linku w przeglądarce

        String currentUrl = driver.getCurrentUrl();   //wyciągamy link z z przeglądarki i przypisujemy go do zmiennej getCurrent

        //sprawdzenie poprawności warunku, czy url jest taki sam jak w zmiennej
        //jeśli nie jest - wyświetlony zostanie tekst
        assertTrue("The current URL isn't dev.to", URL.equals(currentUrl));

    }

   /* @After TearDown(){} */

}
