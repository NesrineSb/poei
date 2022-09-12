package carrefour;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By acceptCookieSelector= By.cssSelector("#onetrust-accept-btn-handler");
    private By searchWithButtonSelector= By.cssSelector("[name=q]");
    private By loupeButtonSelector= By.cssSelector(".header-search__form");




    private final int TIMEOUT_COOKIE = 6;

    public void HomePageCarrefour(WebDriver driver){

        this.driver=driver;
    }
    //click accept cookie button
    public void acceptCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
    }

    //enter keyboard in search  bar and click in button
    public void searchWithButton(String keyword){
        WebElement searchBar = driver.findElement(searchWithButtonSelector);
        searchBar.sendKeys(keyword);
        WebElement loupeButton = driver.findElement(loupeButtonSelector);
        loupeButton.click();
    }
}


