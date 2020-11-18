package br.luiz.appium.page;

import br.luiz.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import static br.luiz.appium.core.DriverFactory.getDriver;

public class ClickPage extends BasePage {


    public void cliqueLongo(String valor){
        AndroidTouchAction touch = new AndroidTouchAction(getDriver());

        touch.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(getDriver()
                .findElement(By.xpath("//*[@text='"+valor+"']")))))
                .perform();
    }

    public String obterTexto(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }

    public void CliqueDuplo(){
        clickByText("Clique duplo");
        clickByText("Clique duplo");
    }

}
