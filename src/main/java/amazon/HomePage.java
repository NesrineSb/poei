package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By acceptCookieSelector= By.cssSelector("[data-cel-widget=sp-cc-accept]");
    private By searchWithButtonSelector= By.cssSelector("[aria-label=Rechercher]");
    private By loupeButtonSelector= By.cssSelector("[type=submit]");




    private final int TIMEOUT_COOKIE = 6;

    public HomePage(WebDriver driver){

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
