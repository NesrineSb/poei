package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;

    private By refuseAppleCareSelector = By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']");
    private By openCardSelector = By.cssSelector("#attach-sidesheet-view-cart-button");
    private By ajouterAuPanierButtonSelector=By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']");

    private final int TIMEOUT= 6;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    //click ajouter au panier button
    public void addToCard(){
        List<WebElement> resultatList = driver.findElements(By.cssSelector("img.s-image"));
        resultatList.get(0).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        WebElement ajouterAuPanierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ajouterAuPanierButtonSelector));
        ajouterAuPanierButton.click();

    }
    //click non merci
    public void refuseAppleCare(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        WebElement nonmerci = wait.until(ExpectedConditions.visibilityOfElementLocated(refuseAppleCareSelector));
        nonmerci.click();

    }
    //click cart button
    public void openCard(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        WebElement panierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(openCardSelector));
        panierButton.click();

    }
}
