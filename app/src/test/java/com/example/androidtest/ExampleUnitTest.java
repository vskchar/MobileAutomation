package com.example.androidtest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.appcenter.espresso.Factory;
import com.microsoft.appcenter.espresso.ReportHelper;

import org.junit.Rule;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import pages.LogIn;
import utility.LaunchApp;


public class ExampleUnitTest extends LaunchApp {
    ExtentHtmlReporter htmlReporter = null;
    ExtentReports extent = null;
    ExtentTest logger = null;
    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();

    @BeforeTest
    public void startReports() {
        htmlReporter = new ExtentHtmlReporter("D:\\AndroidTest\\Reports\\Login.html");
        extent = new ExtentReports ();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Test
    public void TC_1() throws MalformedURLException, InterruptedException {

        setUp();
        logger = extent.createTest("Login To Naukri");
        LogIn login = new LogIn(driver,logger);
        login.loginToNaukri();
    }
    @AfterTest
    public void TearDown(){
        extent.flush();
        reportHelper.label("Stopping App");
    }
}