package br.luiz;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FormTest {
    static AndroidDriver<MobileElement> driver;

    @Before
    public void openApp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\Projetos\\curso-appium\\src\\main\\resources\\CTAppium_1_2.apk");


        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        //selecionar formulário
        List<MobileElement> elements = driver.findElements(By.className("android.widget.TextView"));

        elements.get(1).click();

        //escrever nome
        MobileElement inputText = driver.findElement(MobileBy.AccessibilityId("nome"));
        inputText.sendKeys("Luiz");

        //checar nome escrito
        String text = inputText.getText();
        Assert.assertEquals("Luiz",text);

    }

    @Test
    public void deveIntereagirCombo() throws MalformedURLException {
        //selecionar formulário
        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

        //click in combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();

        //select the option
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        //verify option
        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        Assert.assertEquals("Nintendo Switch", text);
        driver.quit();
    }

    @Test
    public void deveIntereagirSwitch() {
        //selecionar formulário
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();

       //verify element state
        MobileElement checkBox =  driver.findElement(By.className("android.widget.CheckBox"));
        MobileElement inputSwitch   =  driver.findElement(MobileBy.AccessibilityId("switch"));
        Assert.assertTrue(checkBox.getAttribute("checked").equals("false"));
        Assert.assertTrue(inputSwitch.getAttribute("checked").equals("true"));
        //click in element
        checkBox.click();
        inputSwitch.click();
        // verify states change
        Assert.assertTrue(checkBox.getAttribute("checked").equals("true"));
        Assert.assertTrue(inputSwitch.getAttribute("checked").equals("false"));
     }

    @Test
    public void preecherFormulario(){
        //selecionar formulário
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();
        //escrever nome

        driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("Luiz");

        //click in combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();

        driver.findElement(By.className("android.widget.CheckBox")).click();

        driver.findElement(By.xpath("//*[@text='SALVAR']")).click();

        Assert.assertEquals("Nome: Luiz", driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]")).getText());
        Assert.assertEquals("Console: ps4", driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")).getText());
        Assert.assertEquals("Slider: 25", driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]")).getText());
        Assert.assertEquals("Switch: On", driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).getText());
        Assert.assertEquals("Checkbox: Marcado", driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).getText());
        Assert.assertEquals("Data: 01/01/2000", driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Data:')]")).getText());

    }

    @After
    public void closeApp(){
        driver.quit();
    }

}