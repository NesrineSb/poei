import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

public class tp3 {

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
    @Test
    public void testAmazon() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();
        WebElement bouttontouttes= driver.findElement(By.cssSelector("#nav-hamburger-menu"));
        bouttontouttes.click();

       // WebElement bouttonmeilleur= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.hmenu-item']")); bouttonmeilleur.click();
        /*WebElement bouttonmeilleurvente= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='hmenu-item']")));
        bouttonmeilleurvente.click();*/


        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item")));
        List<WebElement> menuList = driver.findElements(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item"));
        menuList.get(0).click();

        /*WebElement imagemeilleurvente= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-mini _p13n-zg-list-carousel-desktop_maskStyle_noop__3Xbw5'])[3]"));
        imagemeilleurvente.click();*/


        List<WebElement> resultatList = driver.findElements(By.cssSelector("div.zg-carousel-general-faceout"));
        resultatList.get(2).click();




}
@Test
    public void test(){
        //Arrange
    //Acte
    //[data-csa-c-content-id="nav_cs_bestsellers"]
    WebElement logo= driver.findElement(By.cssSelector("#nav-logo"));
    WebElement barreRecherche= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
   // WebElement image= driver.findElement(By.cssSelector(".a-carousel-card"));
    WebElement toutesMenu= driver.findElement(By.cssSelector("#nav-hamburger-menu"));
    WebElement meilleuresVentes= driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_bestsellers]"));
    WebElement amazonBasics= driver.findElement(By.cssSelector(""));
    WebElement meilleuresVentesLivres= driver.findElement(By.cssSelector(""));


    //Asserts
    //Assert.assertEquals(logo.isDisplayed(),true);//version1
    Assert.assertTrue(logo.isDisplayed());//version2
    Assert.assertTrue(barreRecherche.isDisplayed());
    Assert.assertEquals(toutesMenu.getText(),"Toutes");

    Assert.assertTrue(meilleuresVentes.isDisplayed());
    Assert.assertEquals(meilleuresVentes.getText(),"Meilleures ventes");

    Assert.assertTrue(amazonBasics.isDisplayed());
    Assert.assertEquals(amazonBasics.getText(),"Amazon Basics");

    Assert.assertTrue(meilleuresVentesLivres.isDisplayed());
    Assert.assertEquals(meilleuresVentesLivres.getText(),"Meilleures ventes dans livres");

}
@Test
public void testAsserts() {
    // Arrange
    final String expectedToutes = "Toutes";
    final String expectedMeilleuresVentes = "Meilleures ventes";
    final String expectedAmazonBasics = "Amazon Basics";
    final String expectedVentesLivres = "Meilleures ventes dans Livres";

    // Act
    WebElement logo = driver.findElement(By.cssSelector("#nav-logo"));
    WebElement barreRecherche = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
    WebElement toutesMenu = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
    WebElement meilleuresVentes = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_bestsellers]"));
    WebElement amazonBasics = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_amazonbasics]"));
    WebElement meilleuresVentesLivres = driver.findElement(By.cssSelector("[data-csa-c-slot-id=desktop-5] h2.as-title-block-left"));

    // Asserts
    Assert.assertTrue(logo.isDisplayed(), "The Amazon Logo is not displayed");
    Assert.assertTrue(barreRecherche.isDisplayed());
    Assert.assertEquals(toutesMenu.getText(), expectedToutes);

    Assert.assertTrue(meilleuresVentes.isDisplayed());
    Assert.assertEquals(meilleuresVentes.getText(), expectedMeilleuresVentes, "The button Meilleures Ventes is not correct");

    Assert.assertTrue(amazonBasics.isDisplayed());
    Assert.assertEquals(amazonBasics.getText(), expectedAmazonBasics);

    Assert.assertTrue(meilleuresVentesLivres.isDisplayed());
    Assert.assertEquals(meilleuresVentesLivres.getText(), expectedVentesLivres);
}}

