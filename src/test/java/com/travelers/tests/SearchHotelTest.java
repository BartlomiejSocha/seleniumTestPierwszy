package com.travelers.tests;

import com.travelers.pages.HomePage;
import com.travelers.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.transform.Result;
import java.util.List;

public class SearchHotelTest extends BaseSeleniumTest {

    @Test
    public void searchHotelTest() {
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = new ResultPage(driver);
        homePage.setCityHotel("Dubai");
        homePage.setDateRange("09/11/2021", "09/13/2021");
        homePage.openTravellersModel();
        homePage.addAdult();
        homePage.addChild();
        homePage.addChild();
        homePage.performSearch();

        List<String> hotelNames = resultPage.getHotelNames();
        Assert.assertEquals("Jumeirah Beach Hotel",hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower",hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana",hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth",hotelNames.get(3));

        List<String> hotelPrices = resultPage.getHotelPrices();
        Assert.assertEquals("$22",hotelPrices.get(0));
        Assert.assertEquals("$50",hotelPrices.get(1));
        Assert.assertEquals("$80",hotelPrices.get(2));
        Assert.assertEquals("$150",hotelPrices.get(3));
    }
}
