package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private final int TIMEOUT = 6;
    private By cardButtonSelector  = By.cssSelector("#data-produit-acheter");

    public CartPage(WebDriver driver) {

        this.driver=driver;
    }


    public void getProductName(){

    }

        public void openCard(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement cardButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cardButtonSelector));
            cardButton.click();

        }

    }

