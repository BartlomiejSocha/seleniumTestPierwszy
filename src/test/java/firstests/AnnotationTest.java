package firstests;

import com.travelers.tests.BaseSeleniumTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class AnnotationTest extends BaseSeleniumTest {

    @FindBys({
            @FindBy(tagName = "table"),
            @FindBy(className = "tableHeader")
    })
    private List<WebElement> elements;

    @FindBy(xpath = "//input")
    private List<WebElement> inputs;

    @FindBy(xpath = "//button")
    private List<WebElement> buttons;

    @FindAll({
            @FindBy(xpath = "//button"),
            @FindBy(xpath = "//input")
    })
    private List<WebElement> inputsAndButtons;

    @Test
    public void googleSearchTest() {
        SeleniumHelper helper = new SeleniumHelper(driver);
        PageFactory.initElements(driver,this);
        driver.get("file:///C:/Users/barts/OneDrive/Pulpit/kurs/wyklad54/Test.html");
        System.out.println("Elements size is " + elements.size());
        System.out.println("Inputs size is " + inputs.size());
        System.out.println("Buttons size is " + buttons.size());
        System.out.println(inputsAndButtons.size());
    }
}
