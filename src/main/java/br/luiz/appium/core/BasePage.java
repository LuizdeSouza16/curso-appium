package br.luiz.appium.core;

import static br.luiz.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

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
        List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));

        return elements.size() > 0;
    }

    public void tap(int x, int y) {
        new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
    }
    
    public void scroll(double inicio, double fim) {
		org.openqa.selenium.Dimension size = DriverFactory.getDriver().manage().window().getSize();
		
		int x = size.width / 2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		new TouchAction<>(DriverFactory.getDriver())
			.press(PointOption.point(x, start_y))	
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(x, end_y))
			.release()
			.perform();
		
	}
}