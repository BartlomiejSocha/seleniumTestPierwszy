package firstests;

import com.travelers.tests.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseSeleniumTest {

    @Test
    public void dragAndDropTest() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //scroll down o 300 pixeli
        js.executeScript("window.scrollBy(0,300)");

        WebElement popupAccept = driver.findElement(By.id("onetrust-button-group"));
        System.out.println(popupAccept.getText());
        popupAccept.click();
        WebElement elementToDrag = driver.findElement(By.id("draggable"));
        WebElement dropZone = driver.findElement(By.id("droptarget"));

        Actions action = new Actions(driver);
        action.dragAndDrop(elementToDrag,dropZone).build().perform();
    }
}
