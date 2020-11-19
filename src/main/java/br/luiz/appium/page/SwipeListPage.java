package br.luiz.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import br.luiz.appium.core.BasePage;
import br.luiz.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeListPage extends BasePage{
	
	public void swipeElementLeft(String opcao) {
		swipeElement(DriverFactory.getDriver()
				.findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
	}
	
	public void swipeElementRight(String opcao) {
		swipeElement(DriverFactory.getDriver()
				.findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
	}
	
	public void clickarBotaoMais() {
		MobileElement botao = DriverFactory.getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
		  Point center1 = botao.getCenter();     
		  new TouchAction(DriverFactory.getDriver()).tap(PointOption.point(center1.x - 50, center1.y)).perform();
	}

}
