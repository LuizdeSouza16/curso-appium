package br.luiz.appium.srbarriga.page;

import org.openqa.selenium.By;

import br.luiz.appium.core.BasePage;
import br.luiz.appium.core.DriverFactory;

public class ResumoPage extends BasePage {

	public void swipeCalculo() {
		swipeElement(DriverFactory.getDriver()
				.findElement(By.xpath("//*[@text='Movimentacao 1, calculo saldo']/..")), 0.9, 0.1);
	}
	
	public void cliqueDel() {
		clickByText("Del");
	}

	public void cliqueAtualizar() {
		clickByText("ATUALIZAR");
	}
}
