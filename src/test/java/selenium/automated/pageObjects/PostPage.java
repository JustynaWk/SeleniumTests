package selenium.automated.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostPage {

    WebDriver driver;

    @FindBy(id = "main-title")
    public WebElement mainTitle;

    public PostPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("crayons-article__header__meta")));
    }

    public boolean isMainTitleVisible(){
        boolean isVisible = mainTitle.isDisplayed();
        return isVisible;
    }
}