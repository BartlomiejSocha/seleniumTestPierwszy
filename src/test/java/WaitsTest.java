import com.travelers.tests.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WaitsTest extends BaseSeleniumTest {

    @Test
    public void waitTest() {
//        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.get("file:///C:/Users/barts/OneDrive/Pulpit/kurs/wyklad54/Waits.html");
        driver.findElement(By.tagName("button")).click();
        waitForWebElement(By.tagName("p"));
        WebElement paragraph = driver.findElement(By.tagName("p"));
        System.out.println(paragraph.getText());
        Assert.assertEquals(paragraph.getText(), "Dopiero się pojawiłem!");
    }

    private void waitForWebElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10L);

/*        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.pollingEvery(Duration.ofMillis(500));
        wait.withTimeout(Duration.ofSeconds(10L));
        wait.ignoring(NoSuchElementException.class);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                System.out.println("sprawdzenie");
                if(driver.findElement(locator).isDisplayed()) {
                    System.out.println("Element jest wyświetlony");
                    return true;
                } else {
                    System.out.println("Element nie jest wyświetlony");
                    return false;
                }
            }
        });*/
        wait.until(driver1 -> {
            System.out.println("sprawdzenie");
            if(driver1.findElement(locator).isDisplayed()) {
                System.out.println("Element jest wyświetlony");
                return true;
            } else {
                System.out.println("Element nie jest wyświetlony");
                return false;
            }
        });

    }
}
