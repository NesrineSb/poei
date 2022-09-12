package carrefour;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By acceptCookieSelector= By.cssSelector("#onetrust-accept-btn-handler");

    private final int TIMEOUT_COOKIE = 6;

    public HomePage(WebDriver driver) {

        this.driver=driver;
    }

    //click accept cookie button
    public void acceptCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
    }



}


