package br.luiz.appium.core;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static br.luiz.appium.core.DriverFactory.getDriver;

public class BasePage {
    public void write(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public void click(By by) {
        getDriver().findElement(by).click();
    }

    public void clickByText(String text) {
        click(By.xpath("//*[@text='" + text + "']"));
    }

    public void selectCombo(By by, String value) {
        getDriver().findElement(by).click();

        clickByText(value);
    }

    public boolean isCheckMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean isExisteElementoPorTexto(String texto) {
        List<MobileElement> elements = getDriver().findElements(By.xpath("*[@text='"+texto+"']"));

        return elements.size() > 0;
    }
}