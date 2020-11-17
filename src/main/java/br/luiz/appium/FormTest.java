package br.luiz.appium;

import br.luiz.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import java.net.MalformedURLException;


public class FormTest {
    private static AndroidDriver<MobileElement> driver;

    @Before
    public void openApp() throws MalformedURLException {
        driver = DriverFactory.getDriver();

        //selecionar formulário
        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
    }

    @Test
    public void devePreencherCampoTexto()  {
        //escrever nome
        MobileElement inputText = driver.findElement(MobileBy.AccessibilityId("nome"));
        inputText.sendKeys("Luiz");

        //checar nome escrito
        String text = inputText.getText();
        Assert.assertEquals("Luiz",text);

    }

    @Test
    public void deveIntereagirCombo() {
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
        DriverFactory.killDriver();
    }

}