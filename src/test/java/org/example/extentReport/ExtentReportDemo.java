package org.example.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extent;
    @BeforeTest
    public void configureReport(){

        //generate path to the report and the html file
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        //create report to the given path as a html file
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        //configure the presentation of the html file
        reporter.config().setReportName("My First Extent Report");
        reporter.config().setDocumentTitle("PDF Extra Testing");

        //report execution - this class executes the report creation
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        //additional config
        extent.setSystemInfo("Tester", "Bilyana");
        extent.setSystemInfo("Test Set", "Regression");


    }

    @Test
    public void initialDemo(){

        //listen for the result of the test to attach it to the created report
        ExtentTest firstTest = extent.createTest("First Test");
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://pdfextra.com");
        driver.close();

        //stops monitoring process. stops waiting for execution and closes the proces
        extent.flush();
    }
}
