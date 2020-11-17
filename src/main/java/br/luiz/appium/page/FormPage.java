package br.luiz.appium.page;

import br.luiz.appium.core.DSL;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FormPage {

    private DSL dsl = new DSL();

    public void writeName(String name) {
        dsl.write(MobileBy.AccessibilityId("nome"), name);
    }

    public String getName() {
        return dsl.getText(MobileBy.AccessibilityId("nome"));
    }

    public void selectCombo(String value) {
        dsl.selectCombo(MobileBy.AccessibilityId("console"), value);
    }

    public String getValueCombo() {
        return dsl.getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clickCheckbox() {
        dsl.click(By.className("android.widget.CheckBox"));
    }

    public void clickSwitch() {
        dsl.click(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarcado() {
        return dsl.isCheckMarcado(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchMarcado() {
        return dsl.isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void clickSave() {
        dsl.click(By.xpath("//*[@text='SALVAR']"));
    }

    public String getNameSaved() {
      return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String getConsoleSaved(){
        return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    public String getSliderSaved(){
        return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]"));
    }

    public String getSwitchSaved(){
        return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }

    public String getCheckboxSaved(){
        return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }

    public String getDateSaved(){
        return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Data:')]"));
    }


}
