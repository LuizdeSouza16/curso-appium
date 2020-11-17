package br.luiz;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FormTest {

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\Projetos\\curso-appium\\src\\main\\resources\\CTAppium_1_2.apk");


        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        AndroidDriver<MobileElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //selecionar formulário
        List<MobileElement> elements = driver.findElements(By.className("android.widget.TextView"));

//        for (MobileElement element: elements ) {
//            System.out.println(element.getText());
//        }
        elements.get(1).click();

        //escrever nome
        MobileElement inputText = driver.findElement(MobileBy.AccessibilityId("nome"));
        inputText.sendKeys("Luiz");

        //checar nome escrito
        String text = inputText.getText();
        Assert.assertEquals("Luiz",text);

        driver.quit();
    }
}