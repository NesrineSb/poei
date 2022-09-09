import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpPageObject {
    final String expectedTaille  = "256Go";
    final String expectedCouleur  = "Vert alpin";
    final String expectedConfiguration  = "Sans AppleCare+";
    final String expectedTotale  = "Sous-total (2 articles):";

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
    public void testPO() {
        String keyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();
        homePage.searchWithButton(keyword);
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCard();
        productPage.refuseAppleCare();
        productPage.openCard();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openSearchResult(0);
        CartPage cartPage = new CartPage(driver);

        // ***********************************Asserts*********************//
        Assert.assertEquals(cartPage.getFirstProductCapacity(), expectedTaille, "Taille pas bon");
        Assert.assertEquals(cartPage.getFirstProductColor(), expectedCouleur, "couleur pas bon");
        Assert.assertEquals(cartPage.getFirstProductConfiguration(), expectedConfiguration, "config pas bon");
        Assert.assertEquals(cartPage.getSubtotalCart(), expectedTotale, "sous total pas bon");

    }
        @Test
        public void test2() {

            HomePage homePage= new HomePage(driver);
            WebElement loginButton = driver.findElement(By.cssSelector("#nav-link-accountList"));

            Actions actions = new Actions(driver);
            actions.moveToElement(loginButton);
            actions.perform();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }








    }
