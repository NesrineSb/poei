package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchResultPage {
    private WebDriver driver;
    private By openSearchResultSelector= By.cssSelector("img.s-image");

    public SearchResultPage(WebDriver driver) {

        this.driver=driver;
    }

    //click the search result with index n
    public void openSearchResult(int index) {
        List<WebElement> resultatList = driver.findElements(openSearchResultSelector);
        resultatList.get(0).click();
    }

    }

