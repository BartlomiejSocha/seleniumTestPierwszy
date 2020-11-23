package com.travelers.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseSeleniumTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.out.println("Before test");
        String driverPath = "C:\\Users\\barts\\IdeaProjects\\seleniumTestPierwszy\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("C://Users//barts//OneDrive//Pulpit//kurs//wyklad54//Test.html");
    }

    @AfterTest
    public void tearDown() {
        System.out.println("After Test");
        //driver.quit();
    }
}
