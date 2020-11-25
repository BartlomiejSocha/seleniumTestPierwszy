package com.travelers.tests;

import com.travelers.helpers.DriverFactory;
import com.travelers.helpers.DriverType;
import com.travelers.helpers.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseSeleniumTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() throws NoSuchDriverException {
        System.out.println("Before test");
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @AfterTest
    public void tearDown() {
        System.out.println("After Test");
        driver.quit();
    }
}
