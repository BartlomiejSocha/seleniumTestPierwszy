package com.travelers.tests;

import com.travelers.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchHotelTest extends BaseSeleniumTest {

    @Test
    public void searchHotelTest() throws InterruptedException {
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);
        homePage.setCityHotel("Dubai");
        homePage.setDateRange("09/11/2021", "09/13/2021");
        homePage.openTravellersModel();
        homePage.addAdult();
        homePage.addChild();
        homePage.performSearch();

        List<String> hotelNames = homePage.getHotelNames();
        Assert.assertEquals("Jumeirah Beach Hotel",hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower",hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana",hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth",hotelNames.get(3));

        List<String> hotelPrices = homePage.getHotelPrices();
        Assert.assertEquals("$22",hotelPrices.get(0));
        Assert.assertEquals("$50",hotelPrices.get(1));
        Assert.assertEquals("$80",hotelPrices.get(2));
        Assert.assertEquals("$150",hotelPrices.get(3));
    }
}
