import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Tp4 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }

    @Test
    public void testAmazon() {
        //******************************* Arrange******************************//
        final String expectedTaille  = "256Go";
        final String expectedCouleur  = "Vert alpin";
        final String expectedConfiguration  = "Sans AppleCare+";
        final String expectedTotale  = "Sous-total (2 articles):";
       // final String expectedTitre  = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";


        // ************************************Act****************************//
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();


        List<WebElement> resultatList = driver.findElements(By.cssSelector("img.s-image"));
        resultatList.get(0).click();


        WebElement ajouterAuPanierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']")));
        ajouterAuPanierButton.click();

        WebElement nonmerci = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']")));
        nonmerci.click();


        WebElement panierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#attach-sidesheet-view-cart-button")));
        panierButton.click();

        WebElement dropdown = driver.findElement(By.cssSelector("#quantity"));
        Select quantiteSelect = new Select(dropdown);
        quantiteSelect.selectByIndex(2);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> informations = driver.findElements(By.cssSelector(".sc-product-variation .a-text-bold + span"));
        WebElement soustotale = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sc-subtotal-label-activecart")));
        //WebElement amazonBasics = driver.findElement(By.cssSelector("#productTitle"));


        // ***********************************Asserts*********************//
        Assert.assertEquals(informations.get(0).getText(),expectedTaille,"Taille pas bon");
        Assert.assertEquals(informations.get(1).getText(),expectedCouleur ,"couleur pas bon");
        Assert.assertEquals(informations.get(2).getText(),expectedConfiguration ,"config pas bon");
        Assert.assertEquals(soustotale.getText(),expectedTotale,"sous total pas bon");
        //Assert.assertEquals(amazonBasics.getText(),expectedTitre,"titre pas bon");



    }
}