package utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    /*
     extentTestMap map - It holds the information of thread ids and ExtentTest instances.
     ExtentReports instance is created by calling getReporter() method from ExtentManager.
     startTest() - an instance of ExtentTest created and put into extentTestMap with current thread id.
     endTest() - test ends and ExtentTest instance got from extentTestMap via current thread id.
     getTest() - return ExtentTest instance in extentTestMap by using current thread id.
   */

    static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest getTest() {
        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest() {
        extent.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}
