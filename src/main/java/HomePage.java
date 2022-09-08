import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By acceptCookieSelector= By.cssSelector("[data-cel-widget=sp-cc-accept]");

    private final int TIMEOUT_COOKIE = 6;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    //click accept cookie button
    public void acceptCookie(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("acceptCookieSelector")));
        buttonCookie.click();
    }



    //enter keyboard in search  bar and click in button
    public void searchWithButton(){

    }

    //enter keyboard in search bar and press
    public void searchWithEnter(){

    }
 }
