package br.luiz.appium.page;

import static br.luiz.appium.core.DriverFactory.getDriver;

import java.util.Set;

import org.openqa.selenium.By;

import br.luiz.appium.core.BasePage;

public class WebViewPage extends BasePage {

	public void entarContextoWeb() {
		Set<String> contextHandles = getDriver().getContextHandles();
	
		getDriver().context((String) contextHandles.toArray()[1]);
	}
	
	public void setEmail(String valor) {
		getDriver().findElement(By.id("email")).sendKeys(valor);;
	}
	
	public void setPass(String valor) {
		getDriver().findElement(By.id("senha")).sendKeys(valor);;
	}
	
	public void clickEntrar() {
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public void sairContextoWeb() {		
		getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
	}
	
	public String getMensagem() {
		return getText(By.xpath("//div[@class='alert alert-success']"));
				
	}
}
