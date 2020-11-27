package utils;

import driver.DriverSingelton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener  implements ITestListener {
private Logger log = LogManager.getRootLogger();
    @Override
    public void onTestFailure(ITestResult result) {
        saveSceenshot();
    }

    private void saveSceenshot() {
        File snapshot = ((TakesScreenshot)DriverSingelton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(snapshot, new File("./target/screenshots/"+ getCurrentTimeAsString()+".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot"+e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
