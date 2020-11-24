package firstests;

import com.travelers.tests.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClickTest extends BaseSeleniumTest {

    @Test
    public void doubleClickTest() {

        SeleniumHelper helper = new SeleniumHelper(driver);
        driver.get("file:///C:/Users/barts/OneDrive/Pulpit/kurs/wyklad54/DoubleClick.html");
        WebElement doubleButton = driver.findElement(By.id("bottom"));

        Actions action = new Actions(driver);
        action.moveToElement(doubleButton).doubleClick().build().perform();
        helper.takeScreenshot();
        Assert.assertTrue(driver.getWindowHandles().size()>1);

    }
}
