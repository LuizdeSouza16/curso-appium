package br.luiz.appium.srbarriga.page;

import org.openqa.selenium.By;

import br.luiz.appium.core.BasePage;

public class SBLoginPage extends BasePage{
	
	public void setLogin() {
		write(By.className("android.widget.EditText"), "luiz@luiz.com");
	}
	
	public void setSenha() {
		write(By.xpath("//android.widget.EditText[2]"), "12345678");
	}
	
	public void entrar() {
		clickByText("ENTRAR");
	}

}
