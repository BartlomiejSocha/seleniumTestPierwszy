import com.travelers.tests.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class JavascriptExecution extends BaseSeleniumTest {


    @Test
    public void googleSearchTest() {
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        WebElement searchInput = driver.findElement(By.name("q"));
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println(iframes.size());

        driver.switchTo().frame(0);
        WebElement acceptButton = driver.findElement(By.id("introAgreeButton"));
        acceptButton.click();

        driver.switchTo().defaultContent();
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        Actions action = new Actions(driver);
        action.contextClick().build().perform();

//        executor.executeScript("alert('Hello world!')");
        executor.executeScript("arguments[0].setAttribute('value', 'Selenium')", searchInput);
//        searchInput.sendKeys("Selenium");
        executor.executeScript("arguments[0].click();", searchInput);
//        searchInput.sendKeys(Keys.ENTER);

        //klikniecie prawym przyciskiem myszy contextclick
    }
}
