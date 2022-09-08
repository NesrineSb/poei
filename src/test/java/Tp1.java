import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Tp1 {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    @Test //Annotation
    public void test1(){
        System.out.println("Test Luis");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void testAmazonps4() {
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBar.sendKeys("Playstation 5");
    }
    //test selecteur xpath
    @Test
    public void testAmazon() {

        WebElement boutton= driver.findElement(By.xpath("//span[@class='a-button-inner']/*[@type='submit']"));
        boutton.click();
        WebElement searchBar =driver.findElement(By.xpath("//input[@aria-label='Rechercher']"));
        searchBar.sendKeys("coque iphone 13");
        WebElement bouttonsearch= driver.findElement(By.xpath("//input[@value='Go']"));
        bouttonsearch.click();
        WebElement img= driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        img.click();
        WebElement ajout = driver.findElement(By.xpath("//input[@aria-labelledby='submit.add-to-cart-announce']"));
        ajout.click();
        WebElement panier = driver.findElement(By.xpath("(//span[@class='nav-line-2'])[2]"));
        panier.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

    @Test
    public void testCss() {


        //final int IMPLICIT_TIMEOUT =10;
         //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Coque iphone 13");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();


        WebElement premierResultat = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]")));
        premierResultat.click();

        WebElement ajouterAuPanierButton = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        ajouterAuPanierButton.click();

        WebElement panierButton = driver.findElement(By.cssSelector("#nav-cart"));
        panierButton.click();
    }


}
