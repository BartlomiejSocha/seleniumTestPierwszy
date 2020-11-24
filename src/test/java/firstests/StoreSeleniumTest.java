package firstests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class StoreSeleniumTest {

    @Test
    public void googleOpenTest() {
        String driverPath = "C:\\Users\\barts\\IdeaProjects\\seleniumTestPierwszy\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
//        Dimension dimension = new Dimension(1800, 1000);
        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com");
//        driver.manage().window().setSize(dimension);
        driver.manage().window().maximize();
        driver.get("C://Users//barts//OneDrive//Pulpit//kurs//wyklad54//Test.html");
//        driver.findElement(By.id("newPage")).click();
        WebElement clickOnMeButton = driver.findElement(By.id("clickOnMe"));
        WebElement clickOnMeButton2 = driver.findElement(By.id("fname"));
        WebElement firstNameInput = driver.findElement(By.name("fname"));
        firstNameInput.sendKeys("Maciek2");

        clickOnMeButton.click();

//       WebElement w3SchoolLink = driver.findElement(By.linkText("Visit W3Schools.com!")); //to do wyszukania tylko tego tekstu bez sensu lepiej partialLinkText
        WebElement googleLink = driver.findElement(By.partialLinkText("IamWeirdLink")); //to do wyszukania danego tekstu

        WebElement topSecretParagraph = driver.findElement(By.className("topSecret"));

        WebElement firstInput = driver.findElement(By.tagName("input"));

        WebElement firstLink = driver.findElement(By.tagName("a"));

        List<WebElement> links = driver.findElements(By.tagName("a"));

        if(links.size()>0) {
            System.out.println("linki istenieją");
        } else {
            System.out.println("Linki nie istnieją");
        }


        //alerty
        clickOnMeButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss(); // można też używać .accept();
        //alert.sendKeys("blabla");
        firstNameInput.sendKeys("Bartek");
        firstNameInput.clear();
        firstNameInput.sendKeys("Tomek");

        //carSelect
        Select carSelect = new Select(driver.findElement(By.tagName("select")));
        //carSelect.selectByIndex(2);
        //carSelect.selectByVisibleText("Mercedes");
        carSelect.selectByValue("audi");

        //getAttribute getText
        firstNameInput.sendKeys("Tomek");
        System.out.println("Wartość to getText " + firstNameInput.getText());
        System.out.println("Wartość to getAttribute " + firstNameInput.getAttribute("value"));
        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println("Wartość label to " + label.getText());

        //checkboxy i radiobuttony
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        WebElement radioButton = driver.findElement(By.xpath("//input[@value='male']"));
        radioButton.click();

        //topSecret
        WebElement paragraph = driver.findElement(By.className("topSecret"));
        System.out.println("moj tekst getText to " + paragraph.getText());
        System.out.println("moj tekst value to " + paragraph.getAttribute("value"));
        System.out.println("moj tekst textContent to " + paragraph.getAttribute("textContent"));

        //obrazek getSize
        WebElement smileImg = driver.findElement(By.id("smileImage"));
        System.out.println("height to " + smileImg.getSize().getHeight());
        System.out.println("height getAttribute to " + smileImg.getAttribute("naturalHeight"));

        // input disabled
        if(firstNameInput.isEnabled()) {
            System.out.println("element nie jest zablokowany");
            firstNameInput.sendKeys("Tomek");
        } else {
            System.out.println("element jest zablokowany");
        }

        //checkbox checked
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (checkbox2.isSelected()){
            System.out.println("Checkbox jest zaznaczony");
            checkbox2.click();
            System.out.println("checkbox został odznaczony");
        } else {
            System.out.println("Checkbox nie jest zaznaczony");
        }

        //hidden element
        WebElement topSecretElement = driver.findElement(By.className("topSecret"));
        if(topSecretElement.isDisplayed()) {
            System.out.println("Element jest widoczny");
            System.out.println(topSecretElement.getText());
        } else {
            System.out.println("Element nie jest widoczny");
            System.out.println(topSecretElement.getAttribute("textContent"));
        }

        //checkIfElementExist
        checkIfElementExist(By.tagName("a"), driver);
        checkIfElementExist(By.tagName("asadsafrgef"), driver);

        checkIfElementExist(driver, By.tagName("a"));
        checkIfElementExist(driver, By.tagName("adsadasd"));

        //swieze okno i switchTo() pomiędzy oknami
        WebElement newPageButton = driver.findElement(By.id("newPage"));

        String currentWindowName = driver.getWindowHandle();

        newPageButton.click();

        System.out.println("Tytuł pierwotny to " + driver.getTitle());
        System.out.println("Pierwotny URL to " + driver.getCurrentUrl());

        switchToNewWindow(driver, currentWindowName);

        System.out.println("Tytuł po wywołaniu switchToNewWindow strony to " + driver.getTitle());
        System.out.println("URL po wywołaniu switchToNewWindow to " + driver.getCurrentUrl());
        driver.switchTo().window(currentWindowName);
        driver.findElement(By.name("username")).sendKeys(" Mouse");

        //wyszukiwanie klikanie klawiszy
        driver.get("https://www.google.com");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Selenium");
/*        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchInput.sendKeys(Keys.ESCAPE);
        searchButton.click();*/
        searchInput.sendKeys(Keys.ENTER);
        WebElement seleniumPageLink = driver.findElement(By.linkText("Selenium WebDriver"));
        seleniumPageLink.click();

        WebElement clickOnMeCss = driver.findElement(By.cssSelector("#clickOnMe"));
        WebElement clickOnMeXpath = driver.findElement(By.xpath("//*[@id=\"clickOnMe\"]"));
        driver.quit();
    }


    public boolean checkIfElementExist(By locator, WebDriver driver) {
        if(driver.findElements(locator).size()>0) {
            System.out.println("Element istnieje na stronie ");
            return true;
        } else {
            System.out.println("Brak elementu na stronie");
            return false;
        }
    }

    public void checkIfElementExist(WebDriver driver, By locator){
        try {
            driver.findElement(locator);
            System.out.println("element istnieje na stronie");

        } catch(NoSuchElementException exc) {
            System.out.println("element nie istnieje na stronie");
        }
    }
    private void switchToNewWindow(WebDriver driver, String currentWindowName) {
        System.out.println("Wartość dla obecnego okna to " + currentWindowName);
        Set<String> windows  = driver.getWindowHandles();
        System.out.println("Ilość okien przegladarki " + windows.size());
        for(String window : windows){
            if (!window.equals(currentWindowName)){
                driver.switchTo().window(window);
            }

        }
    }
}
