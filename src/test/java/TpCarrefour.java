import carrefour.HomePage;
import carrefour.Shopping;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpCarrefour {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://carrefour.fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }

    @Test
    public void testCarrefour() {
        HomePage homePage = new HomePage (driver);
        homePage.acceptCookie();
        Shopping shopping=new Shopping(driver);
        shopping.selectShopping();
        shopping.chooseRayon();
        shopping.chooseBestSeller();
        shopping.chooseSportHobby();



        //BestSeller bestSeller=new BestSeller(driver);





    }

}
