package Lametayel;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotTaker {     // extends TestWatcher

    private WebDriver driver;

    public static Logger log = LogManager.getLogger(ScreenshotTaker.class.getName());

    public ScreenshotTaker(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



   // @Override
    public void failed(Throwable e, Description description) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        try {
            FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshots\\" + description.getMethodName() + timeStamp + ".png"));
            log.info("Screenshot of failed test saved in " + GeneralProperties.savedScreenshotLocation);

        } catch (Exception exception) {
            exception.printStackTrace();
            log.error("Failed to save screenshot of failed test");
        }
    }
}