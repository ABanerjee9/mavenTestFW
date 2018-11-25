package utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

//ExtentReports object is created and it can be reachable through getReporter() method.

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResults.html", true);
        }
        return extent;
    }
}
