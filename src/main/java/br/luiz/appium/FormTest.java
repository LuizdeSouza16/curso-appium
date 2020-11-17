package br.luiz.appium;

import br.luiz.appium.core.DSL;
import br.luiz.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import java.net.MalformedURLException;


public class FormTest {
    private DSL dsl = new DSL();

    @Before
    public void openApp() throws MalformedURLException {
        dsl.clickByText("Formulário");
    }

    @Test
    public void devePreencherCampoTexto()  {
        //escrever nome
        dsl.write(MobileBy.AccessibilityId("nome"), "Luiz");

        Assert.assertEquals("Luiz", dsl.getText(MobileBy.AccessibilityId("nome")));

    }

    @Test
    public void deveIntereagirCombo() {
        //click in combo
        dsl.selectCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

        //verify option
        String text = dsl.getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
        Assert.assertEquals("Nintendo Switch", text);
    }

    @Test
    public void deveIntereagirSwitch() {

        Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

        //click in element
        dsl.click(By.className("android.widget.CheckBox"));
        dsl.click(MobileBy.AccessibilityId("switch"));

        // verify states change
        Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
     }

    @Test
    public void deveRealizarCadastro(){

        dsl.write(MobileBy.AccessibilityId("nome"), "Luiz");

        //click in combo
        dsl.click(By.className("android.widget.CheckBox"));
        dsl.click(By.className("android.widget.Switch"));
        dsl.selectCombo(By.className("android.widget.Spinner"), "PS4");
        dsl.click(By.xpath("//*[@text='SALVAR']"));

        Assert.assertEquals("Nome: Luiz", dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]")));
        Assert.assertEquals("Console: ps4", dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));
        Assert.assertEquals("Slider: 25", dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]")));
        Assert.assertEquals("Switch: Off", dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")));
        Assert.assertEquals("Checkbox: Marcado", dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")));
        Assert.assertEquals("Data: 01/01/2000", dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Data:')]")));

    }

    @After
    public void closeApp(){
        DriverFactory.killDriver();
    }

}