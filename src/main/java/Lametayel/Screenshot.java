package Lametayel;

import org.apache.commons.lang3.StringUtils;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Lametayel.GeneralProperties;   //gitignore
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;


public class Screenshot {

    private static WebDriver driver;


    public static void initScreenshot(WebDriver dr) {
        driver = dr;
    }

    // save screenshot
    public static void saveScreenshot(String fileName) throws Exception {

        if (StringUtils.equals(GeneralProperties.CAPTURE, "yes")) {

            TakesScreenshot ts = (TakesScreenshot) driver;
            Thread.sleep(1000);
            File source = ts.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(source, new File(GeneralProperties.savedScreenshotLocation + "\\" + fileName));
            } catch (IOException e) {
                System.out.println("cannot save screenshot " + e);
            }
        }
    }

    public static void createScreenshotFolder(String testName) {

        if (StringUtils.equals(GeneralProperties.CAPTURE, "yes")) {

            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String filesPath = "C:\\Users\\user\\git\\Sanity\\Screenshots\\" + testName + "\\" + time;
            new File(filesPath).mkdirs();
            System.out.println("save screenshots in: " + filesPath);
            GeneralProperties.savedScreenshotLocation = filesPath;
        }
    }

}
