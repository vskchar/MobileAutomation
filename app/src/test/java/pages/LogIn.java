package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import filereader.Constants;
import filereader.ExcelConnections;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class LogIn {

    public AndroidDriver<WebElement> driver = null;
    private ExcelConnections excelConnections = null;
    ExtentTest logger = null;

    public LogIn(AndroidDriver<WebElement> driver,ExtentTest logger) {

        this.driver = driver;
        this.logger = logger;
        this.excelConnections = new ExcelConnections(Constants.excelFilePath);
    }
    public WebElement login() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElementById("naukriApp.appModules.login:id/b_login");
    }
    public WebElement emailAddress() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElementById("naukriApp.appModules.login:id/et_email");
    }
    public WebElement password() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElementById("naukriApp.appModules.login:id/et_password");
    }
    public WebElement loginButton() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElementById("naukriApp.appModules.login:id/bt_login");
    }

    public void loginToNaukri() throws InterruptedException {

        login().click();
        logger.log(Status.PASS,"Click on Login Button");
        String username = excelConnections.getCellData("Sheet1","Username",2);
        System.out.println(username);
        emailAddress().sendKeys(username);
        logger.log(Status.PASS,"Username value entered");
        String password = excelConnections.getCellData("Sheet1","Password",2);
        password().sendKeys(password);
        logger.log(Status.PASS,"Password value entered");
        loginButton().click();
        logger.log(Status.PASS,"Click on Login Button");
    }

}
