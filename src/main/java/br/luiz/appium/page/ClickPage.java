package br.luiz.appium.page;

import br.luiz.appium.core.BasePage;
import br.luiz.appium.core.DriverFactory;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import static br.luiz.appium.core.DriverFactory.getDriver;

public class ClickPage extends BasePage {


    public void cliqueLongo(String valor){
        AndroidTouchAction touch = new AndroidTouchAction(getDriver());
        touch.longPress(LongPressOptions.longPressOptions().withElement(
                ElementOption.element(getDriver().findElement(By.xpath("//*[@text='"+valor+"']")))))
                .perform();
    }

    public String obterTexto(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
