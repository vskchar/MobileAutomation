package com.example.androidtest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import pages.LogIn;
import utility.LaunchApp;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest extends LaunchApp {
    ExtentHtmlReporter htmlReporter = null;
    ExtentReports extent = null;
    ExtentTest logger = null;

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
    public void endReport(){
        extent.flush();
    }
}