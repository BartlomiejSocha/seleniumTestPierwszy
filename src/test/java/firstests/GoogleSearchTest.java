package firstests;

import com.travelers.tests.BaseSeleniumTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class GoogleSearchTest extends BaseSeleniumTest {

    @FindBy(name = "q")
    private List<WebElement> searchInput;



    @Test
    public void googleSearchTest() {
        SeleniumHelper helper = new SeleniumHelper(driver);
        PageFactory.initElements(driver,this);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.switchTo().frame(0);
        WebElement acceptButton = driver.findElement(By.id("introAgreeButton"));
        acceptButton.click();
        driver.switchTo().defaultContent();
        searchInput.get(0).sendKeys("Selenium");
        helper.takeScreenshot();
        searchInput.get(0).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("Selenium WebDriver")).click();
        helper.takeScreenshot();
        Assert.assertEquals(driver.getTitle(), "Selenium (software) - Wikipedia");
    }
}
