import com.travelers.tests.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseSeleniumTest {

    @Test
    public void fileUploadTest() {
        driver.get("file:///C:/Users/barts/OneDrive/Pulpit/kurs/wyklad54/FileUpload.html");
        String pathUpload = new File("src/main/resources/test220657600.png").getAbsolutePath();
        driver.findElement(By.id("myFile")).sendKeys(pathUpload);
    }
}
