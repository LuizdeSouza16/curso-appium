package br.luiz.appium.core;

import org.openqa.selenium.By;


import static br.luiz.appium.core.DriverFactory.*;

public class DSL {

    public void write(By by, String text){
        getDriver().findElement(by).sendKeys(text);
    }

    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public void click(By by){
        getDriver().findElement(by).click();
    }

    public void clickByText(String text) {
        click(By.xpath("//*[@text='"+text+"']"));
    }
    public void selectCombo(By by, String value){
        getDriver().findElement(by).click();

        //select the option
      clickByText(value);
    }

    public boolean isCheckMarcado(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

}
