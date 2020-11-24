package firstests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreDrugiSeleniumTest {


@Test
        public void listaTestow() {
    String driverPath = "C:\\Users\\barts\\IdeaProjects\\seleniumTestPierwszy\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", driverPath);
//        Dimension dimension = new Dimension(1800, 1000);
    WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com");
//        driver.manage().window().setSize(dimension);
    driver.manage().window().maximize();
    driver.get("C://Users//barts//OneDrive//Pulpit//kurs//wyklad54//Test.html");


    //
    driver.get("https://www.selenium.dev/");
/*        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Selenium");
        searchInput.sendKeys(Keys.ENTER);
        WebElement seleniumPageLink = driver.findElement((By.linkText("Selenium WebDriver")));
        seleniumPageLink.click();*/

    String expectedTitle = "SeleniumHQ Browser Automation";
    System.out.println(driver.getTitle());

    Assert.assertEquals(expectedTitle, driver.getTitle());
    Assert.assertNotEquals("Test1", "Test2");
    Assert.assertTrue(expectedTitle.equals(driver.getTitle()));
    Assert.assertTrue(driver.getTitle().equals("Zły tekst"), "Tytuły nie są równe");
}
}
