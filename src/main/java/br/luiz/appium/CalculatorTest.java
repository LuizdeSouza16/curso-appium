package br.luiz.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {
    static AndroidDriver<MobileElement> driver;


    @Before
    public void abrirEmulador() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl ,desiredCapabilities);
    }

    @Test
    public void deveSomarDoisNumeros() throws MalformedURLException {


        MobileElement el1 = (MobileElement) driver.findElementById("digit_2");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("digit_2");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("result");

        Assert.assertEquals("4", el4.getText());

    }

    @After
    public void fechar() {
        driver.quit();
    }
}
