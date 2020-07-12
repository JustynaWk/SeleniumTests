package selenium.automated.pageObjects;

import org.openqa.selenium.WebDriver;

public class DevToMainPage {

    String URL = "https://dev.to/";
    WebDriver driver;

    public DevToMainPage (WebDriver driver) {
        this.driver = driver;
        driver.get(URL);



    }
}
