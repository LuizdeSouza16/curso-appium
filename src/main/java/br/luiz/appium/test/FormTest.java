package br.luiz.appium.test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.FormPage;
import br.luiz.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FormTest extends BaseTest {
    private MenuPage menu = new MenuPage();
    private FormPage form = new FormPage();

    @Before
    public void openApp()  {
        menu.accessForm();
    }

    @Test
    public void devePreencherCampoTexto()  {
        form.writeName("Luiz");
        Assert.assertEquals("Luiz", form.getName());
    }

    @Test
    public void deveIntereagirCombo() {
        form.selectCombo("Nintendo Switch");

        Assert.assertEquals("Nintendo Switch", form.getValueCombo());
    }

    @Test
    public void deveIntereagirSwitch() {
        Assert.assertFalse(form.isCheckMarcado());
        Assert.assertTrue(form.isSwitchMarcado());

        form.clickCheckbox();
        form.clickSwitch();

        Assert.assertTrue(form.isCheckMarcado());
        Assert.assertFalse(form.isSwitchMarcado());
     }

    @Test
    public void deveRealizarCadastro(){

        form.writeName("Luiz");
        form.clickCheckbox();
        form.clickSwitch();
        form.selectCombo("PS4");
        form.clickSave();

        Assert.assertEquals("Nome: Luiz",form.getNameSaved());
        Assert.assertEquals("Console: ps4", form.getConsoleSaved());
        Assert.assertEquals("Slider: 25", form.getSliderSaved());
        Assert.assertEquals("Switch: Off", form.getSwitchSaved());
        Assert.assertEquals("Checkbox: Marcado", form.getCheckboxSaved());
        Assert.assertEquals("Data: 01/01/2000", form.getDateSaved());
    }
    @Test
    public void deveRealizarCadastroDemorado(){

        form.writeName("Luiz");
        form.clickCheckbox();
        form.clickSwitch();
        form.selectCombo("PS4");
        form.clickSaveDemorado();

        Assert.assertEquals("Nome: Luiz",form.getNameSaved());
        Assert.assertEquals("Console: ps4", form.getConsoleSaved());
        Assert.assertEquals("Slider: 25", form.getSliderSaved());
        Assert.assertEquals("Switch: Off", form.getSwitchSaved());
        Assert.assertEquals("Checkbox: Marcado", form.getCheckboxSaved());
        Assert.assertEquals("Data: 01/01/2000", form.getDateSaved());
    }

    @Test
    public void deveAlterarData(){
        form.clickByText("01/01/2000");
        form.clickByText("20");
        form.clickByText("OK");
        Assert.assertTrue(form.isExisteElementoPorTexto("20/2/2000"));
    }

    @Test
    public void deveAlterarHorario(){
        form.clickByText("06:00");
        form.click(MobileBy.AccessibilityId("5"));
        form.click(MobileBy.AccessibilityId("15"));
        form.clickByText("OK");
        Assert.assertTrue(form.isExisteElementoPorTexto("5:15"));
    }

    @Test
    public void deveInteragirComSeekbar (){

        form.clickcarSeekBar(0.05);
        form.clickByText("SALVAR");
    }
}