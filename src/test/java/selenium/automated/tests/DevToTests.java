package selenium.automated.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.automated.pageObjects.DevToMainPage;
import selenium.automated.pageObjects.PostPage;
import selenium.automated.pageObjects.WeekPage;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DevToTests {

    WebDriver driver;                             //pusta przeglądarka

    String URL = "https://dev.to/";              //link, ktory ma byc otwarty

    public void HighlightElement(WebElement element) {   //metoda, która bedzie podświetlać element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }


    @Before
    public void SetUp() {                               //metoda set-up odnosi się do Before - warunki początkowe

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SDA dokumenty\\SeleniumDrivers\\chromedriver.exe"); //ścieżka do chrome drivera
        driver = new ChromeDriver();                 //zdefiniowanie przeglądarki jako chrome
        driver.manage().window().maximize();          //powiększenie okna przeglądarki
        driver.get(URL);                             // otworzenie linku w przeglądarce

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //implicityly wait - jeśli nie możesz znaleźć elementu, zaczekaj na dostępność
    }

    @Test
    public void FirstTest() {

        String currentUrl = driver.getCurrentUrl();             //wyciągamy link z z przeglądarki i przypisujemy go do zmiennej getCurrent
        assertTrue("The current URL isn't dev.to", URL.equals(currentUrl));  //sprawdzenie poprawności warunku, czy url jest taki sam jak w zmiennej; jeśli nie jest - wyświetlony zostanie tekst

    }

    @Test
    public void GoToWeekAndOpenTheFirstPost() {
        WebElement week = driver.findElement(By.cssSelector("#on-page-nav-controls > div > nav > a:nth-child(2)")); //znalezienie elementu week na stronie
        HighlightElement(week); // podswietlenie elementu week
        week.click(); // klikniecie elementu week

        WebDriverWait wait = new WebDriverWait(driver, 5); //zainicjalizowanie Explicit Wait
        wait.until(ExpectedConditions.urlToBe("https://dev.to/top/week")); //poczekaj aż url będzie : https://dev.to/top/week
        //wait.until(ExpectedConditions.attributeContains(week,"class","item--current"));

        WebElement firstPostOnWeek = driver.findElement(By.className("crayons-story__body")); //odnalezienie pierwszego posta
        HighlightElement(firstPostOnWeek); //podswietlenie 1 postu
        WebElement firstPostTitle = driver.findElement(By.cssSelector(".crayons-story__title > a")); //znajdź element za pomocą cssSelector -  będzie to nazwa 1 posta
        HighlightElement(firstPostTitle);
        String linkToFirstPost = firstPostTitle.getAttribute("href"); //wyciagnij z nazwy pierwszego posta link do strony
        firstPostOnWeek.click(); //klikniecie 1 postu

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("crayons-article__header__meta"))); //poczekaj aż się przeładuje
        String currentUrl = driver.getCurrentUrl(); //wyciagnij obecny link  //pobierz link do kontroli

        assertEquals("url isn't the same as link(href) value", linkToFirstPost, currentUrl);      //sprawdz czy link do postu jest taki sam jak obecny url
    }

    @Test
    public void OpenDevToObject(){
        DevToMainPage devToMainPage = new DevToMainPage(driver);
        WeekPage weekPage = devToMainPage.GoToWeek();
        PostPage postPage = weekPage.GoToFirstPostPage();
        boolean isMainTitleVisible = postPage.isMainTitleVisible();

        assertTrue("main title isn't visible",isMainTitleVisible);
    }

   /* @After
    public void TearDown(){

        driver.quit();
        System.out.println("Bardzo dobrze");

    } */

}
