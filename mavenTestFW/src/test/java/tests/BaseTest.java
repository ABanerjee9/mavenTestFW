package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public static ExtentTest test ;
    public static ExtentReports extent;

    @BeforeSuite
    public void beforeSuite(){

        extent = new ExtentReports(System.getProperty("user.dir") +"\\ExtentReports\\ExtentReportResults.html", true);
        extent.loadConfig(new File(System.getProperty("user.dir")+ "\\extent-config.xml"));
    }

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        //Create a wait. All test and page classes use this wait.
        wait = new WebDriverWait(driver,15);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
        extent.close();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
