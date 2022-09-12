package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Shopping {
    private By buttonShoppingSelector = By.xpath("//*[@id='data-top-bar']/div/div/div[2]/label/div");

    private By  ButtonresultSelector  = By.xpath("//*[@id='data-menu-level-0']/li[5]/a");
    private By  buttonRayonsSelector  = By.xpath(("//*[@id='data-rayons']/span[2]"));
    private By  ButtonBestSellerSelector  = By.xpath("//*[@id=data-menu-level-0]/li[5]/a");



    private WebDriver driver;
    private final int TIMEOUT = 6;
    public Shopping(WebDriver driver) {

        this.driver = driver;
    }

    public void selectShopping() {


        WebElement buttonShopping = driver.findElement(buttonShoppingSelector);
        buttonShopping.click();
    }
        public void chooseRayon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

        WebElement buttonRayons = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonRayonsSelector));
        buttonRayons.click();
        }


    public void chooseSportHobby () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        WebElement Buttonresult = wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonresultSelector));
        Buttonresult.click();
    }
    public void chooseBestSeller () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        WebElement ButtonBestSeller = wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonBestSellerSelector));
        ButtonBestSeller.click();
    }

}
