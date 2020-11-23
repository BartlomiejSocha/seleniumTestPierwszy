package com.travelers.tests;

import com.travelers.pages.HomePage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchHotelTest extends BaseSeleniumTest {

    @Test
    public void searchHotelTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);
        homePage.setCityHotel("Dubai");
        homePage.setDateRange("09/11/2021", "09/13/2021");
        homePage.openTravellersModel();
        homePage.addAdult();
        homePage.addChild();
    }
}
