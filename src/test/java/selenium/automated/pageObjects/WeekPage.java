package selenium.automated.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeekPage {
    public String url = "https://dev.to/top/week";
    public WebDriver driver;

    @FindBy(css = ".crayons-story__title > a")
    public WebElement firstPostTitle;

    public WeekPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        WebDriverWait wait = new WebDriverWait(driver, 5); //zainicjalizowanie Explicit Wait
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public String GetFirstPostLink(){
        String link = firstPostTitle.getAttribute("href");
        return link;
    }

    public PostPage GoToFirstPostPage(){
        firstPostTitle.click();
        return new PostPage(driver);
    }
}
