package com.travelers.helpers;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            System.out.println("On test failure");
            SeleniumHelper.takeScreenshot(DriverFactory.getDriver(DriverType.CHROME));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchDriverException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("On test failure but within percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("On test failure without timeout");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("On start");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On finish");
    }
}