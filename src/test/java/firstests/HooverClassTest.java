package firstests;

import com.travelers.tests.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HooverClassTest extends BaseSeleniumTest {

    @Test
    public void hooverTest() {
        driver.get("https://www.w3schools.com");

        Actions action = new Actions(driver);
//        action.contextClick().build().perform();
        action.moveToElement(driver.findElement(By.id("navbtn_tutorials"))).build().perform();
    }
}
