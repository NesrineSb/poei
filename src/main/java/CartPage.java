import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private By selectQuantitySelector = By.cssSelector("#quantity");
    private By getSubtotalCartSelector = By.cssSelector("#sc-subtotal-label-activecart");
    private By getFirstProductSelector = By.cssSelector(".a-text-bold + span");


    private final int TIMEOUT_SubtotalCart = 6;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    //select quantity in quantity dropdown
    public void selectQuantity(){
        WebElement dropdown = driver.findElement(By.cssSelector("selectQuantitySelector"));
        Select quantiteSelect = new Select(dropdown);
        quantiteSelect.selectByIndex(2);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        }
    //return text of first product name
    public void getFirstProductName(){

    }
    //return text of first product capacity
    public String getFirstProductCapacity(){
        List<WebElement> informations = driver.findElements(By.cssSelector("getFirstProductSelector"));
        WebElement taille = informations.get(0);
        return taille.getText();

    }
    //return text of color
    public String getFirstProductColor(){
        List<WebElement> informations = driver.findElements(getFirstProductSelector);
        WebElement couleur = informations.get(1);
        return couleur.getText();


    }

    //return text of Configuration
    public String getFirstProductConfiguration(){
        List<WebElement> informations = driver.findElements(getFirstProductSelector);
        WebElement configuration = informations.get(2);
        return configuration.getText();

    }
    //return subtotal text at the buttom of the cart
    public String getSubtotalCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SubtotalCart));
        WebElement soustotale = wait.until(ExpectedConditions.visibilityOfElementLocated(getSubtotalCartSelector));
        return soustotale.getText();

    }
}