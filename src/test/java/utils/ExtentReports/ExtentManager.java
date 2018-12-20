package utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            String str_time;
            Date exec_time = new Date();
            DateFormat dateFormatEx = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            str_time = dateFormatEx.format(exec_time);
            System.out.println(str_time);
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "\\extentReports\\ReporteSQA-Cliente" + "-" + str_time + ".html", true);
        }
        return extent;
    }
}
