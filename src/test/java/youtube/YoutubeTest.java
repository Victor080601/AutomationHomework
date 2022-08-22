package youtube;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YoutubeTest {
    public WebDriver driver;

    @Test
    public void youtubeMethod() {
        //setez driverul de chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //deschid un browser de chrome
        driver = new ChromeDriver();
        //accesez un anumit URL
        driver.get("https://www.youtube.com/");

        //facem browser-ul maximaze
        driver.manage().window().maximize();

        WebElement buttonElement = driver.findElement(By.cssSelector("yt-formatted-string[class='style-scope ytd-button-renderer style-primary size-default']"));
        buttonElement.click();
        //driver.navigate().to("https://www.youtube.com/");

        String actualPage = driver.getTitle();
        String expectedPage = "YouTube";
        Assert.assertEquals(actualPage,expectedPage);

        // WebElement searchElement = driver.findElement(By.id("search-container"));
        //searchElement.click();


        WebElement searchBarElement = driver.findElement(By.id("search"));
        String searchValue = "The Mountain";
        searchBarElement.sendKeys(searchValue);

        WebElement searchButtonElement = driver.findElement(By.id("search-icon-legacy"));
        searchButtonElement.click();
    }
}

