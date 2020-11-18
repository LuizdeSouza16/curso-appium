package br.luiz.appium.page;

import br.luiz.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static br.luiz.appium.core.DriverFactory.getDriver;

public class FormPage extends BasePage {


    public void writeName(String name) {
        write(MobileBy.AccessibilityId("nome"), name);
    }

    public String getName() {
        return getText(MobileBy.AccessibilityId("nome"));
    }

    public void selectCombo(String value) {
        selectCombo(MobileBy.AccessibilityId("console"), value);
    }

    public String getValueCombo() {
        return getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clickCheckbox() {
        click(By.className("android.widget.CheckBox"));
    }

    public void clickSwitch() {
        click(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarcado() {
        return isCheckMarcado(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchMarcado() {
        return isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void clickSave() {
        clickByText("SALVAR");
    }

    public void clickSaveDemorado() {
        clickByText("SALVAR DEMORADO");
    }

    public String getNameSaved() {
      return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String getConsoleSaved(){
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    public String getSliderSaved(){
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]"));
    }

    public String getSwitchSaved(){
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }

    public String getCheckboxSaved(){
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }

    public String getDateSaved(){
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Data:')]"));
    }

    public void clickcarSeekBar(double position){
        int delta = 55;
        MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
        int y = seek.getLocation().y  + (seek.getSize().height / 2);

        int xInicial = seek.getLocation().x + delta;
        int x = (int) ( xInicial + ((seek.getSize().width -2 * delta)* position));

        tap(x,y);
    }

}
