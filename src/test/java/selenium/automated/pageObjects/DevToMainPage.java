package selenium.automated.pageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DevToMainPage { //stworzenie klasy DevToMainPage, na podstawie strony
    public String url = "https://dev.to/";
    public WebDriver driver;

    @FindBy(css="#on-page-nav-controls > div > nav > a:nth-child(2)")
    public WebElement week;

    public DevToMainPage(WebDriver driver){ //implementacja konstruktora
        this.driver = driver; //przekazanie driver, z klasy testRunner (DevToTest)
        driver.get(url); //przejscie pod url
        PageFactory.initElements(driver,this); //zainicjalizować wszystkie elementy FindBy
    }

    public WeekPage GoToWeek(){
        week.click();
        return new WeekPage(driver);
    }

}