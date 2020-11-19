package br.luiz.appium.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.luiz.appium.core.BasePage;
import br.luiz.appium.core.DriverFactory;
import br.luiz.appium.page.MenuPage;

public class OpcaoEscondidaTest extends BasePage{
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveEncontrarMenuEscondido() {
		
		//scroll down
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		
		scrollDown();
	
		menu.clickByText("Opção bem escondida");
	
	
		menu.clickByText("OK");
	}
	
}
