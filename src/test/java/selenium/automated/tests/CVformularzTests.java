/* Zadanie:
1. Wejdź na https://interviewme.pl/kreator-cv
2. Wybierz szablon CV
3. Napisz swoje CV
4. Uzupełnij wszystkie dane
5. Na ostatniej stronie oczkekuj informacji: "Gratulacje, Twoje CV jest gotowe!" */


package selenium.automated.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CVformularzTests {

    WebDriver driver;
    String URL = "https://interviewme.pl/kreator-cv";

    @Before
    public void SetUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owca\\Desktop\\intelliJ - projekty\\SeleniumWebdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void CVcreator() {

        WebElement Szablon = driver.findElement(By.xpath("/html/body/main/section/div/section[2]/div/a[1]/img"));
        Szablon.click();

        WebElement RozpocznijButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/a"));
        RozpocznijButton.click();

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Figa");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("The Cat");

        WebElement zawod = driver.findElement(By.className("UEZP0"));
        zawod.sendKeys("Prezes Zarządu");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[3]/div[1]/div/div[1]/input"));
        email.sendKeys("hiten.style@gmail.com");

        WebElement telefon = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[3]/div[2]/div/div[1]/input"));
        telefon.sendKeys("123456789");

        WebElement adres = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[3]/div[3]/div/div[1]/textarea"));
        adres.sendKeys("Urocza Gdynia\nDzielnica ze sporą ilością zieleni\nChata wypasiona nr 1");

        //Select zawodWybor = new Select(driver.findElement(By.className("_2lnMd")));
        //zawodWybor.selectByVisibleText("Prezes zarządu");

        }


}
