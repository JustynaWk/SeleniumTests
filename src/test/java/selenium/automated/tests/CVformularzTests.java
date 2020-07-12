/* Zadanie:
1. Wejdź na https://interviewme.pl/kreator-cv
2. Wybierz szablon CV
3. Napisz swoje CV
4. Uzupełnij wszystkie dane
5. Na ostatniej stronie oczkekuj informacji: "Gratulacje, Twoje CV jest gotowe!" */


package selenium.automated.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
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

        //strona pierwsza formularza

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

        WebElement Dalej = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[4]/div/button/div"));
        Dalej.click();

        //wyskakujacy pop-up

        WebElement alert = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/button/div/span"));
        alert.click();


        //strona druga formularza

        WebElement nazwaFirmy = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[1]/div[1]/div[1]/div[1]/input"));
        nazwaFirmy.sendKeys("Mieszkanie Człowieków");

        WebElement miasto = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[1]/div[1]/div[2]/div[1]/input"));
        miasto.sendKeys("Gdynia");

        WebElement Stanowisko = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[1]/div[2]/input"));
        Stanowisko.sendKeys("Prezes zarządu");

        Select rokRozpoczecia = new Select(driver.findElement(By.name("year")));
        rokRozpoczecia.selectByVisibleText("2015");

        Select miesiacRozpoczecia = new Select(driver.findElement(By.name("month")));
        miesiacRozpoczecia.selectByVisibleText("Marzec");

        //WebElement opisStanowiska = driver.findElement(By.className("tox-tbtn__select-label"));
        //opisStanowiska.click();

        //WebElement czynnosciStanowisko = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[2]/div[1]/p"));
        //czynnosciStanowisko.click();
        //WebElement czynnosciStanowisko2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[2]/div[3]/p"));
        //czynnosciStanowisko2.click();
        //WebElement czynnosciStanowisko3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[2]/div[4]/p"));
        //czynnosciStanowisko3.click();




        //Select zawodWybor = new Select(driver.findElement(By.className("")));
        //zawodWybor.selectByVisibleText("Prezes zarządu");

        }


}
