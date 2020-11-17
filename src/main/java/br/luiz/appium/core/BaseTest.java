package br.luiz.appium.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyFile;

public class BaseTest {
    @Rule
    public TestName testName = new TestName();
    @After
    public void tearDown(){
        generateScreenshot();
        DriverFactory.getDriver().resetApp();
    }

    @AfterClass
    public static void closeApp(){
        DriverFactory.killDriver();
    }
    public void generateScreenshot() {
        File imagen = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);

        try {
            copyFile(imagen, new File("target\\screenshots\\"+testName.getMethodName()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
