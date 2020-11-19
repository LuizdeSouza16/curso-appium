package br.luiz.appium.srbarriga.page;

import org.openqa.selenium.By;

import br.luiz.appium.core.BasePage;

public class MovPage extends BasePage{

	public void setDescricao() {
		write(By.xpath("//android.widget.EditText[@text='Descrição']"), "Descrição do pagamento");
	}
	
	public void setInteressado() {
		write(By.xpath("//android.widget.EditText[@text='Interessado']"), "Luiz Ubiratan");
		
	}
	
	public void setValor() {
		write(By.xpath("//android.widget.EditText[@text='Valor']"), "150,00");
	}
	
	public void clicarSwitch() {
		click(By.className("android.widget.Switch"));
	}
	
	public void cliqueSelecionarConta() {
		clickByText("Selecione uma conta...");
	}
	
	public void clicarContaMesmoNome() {
		clickByText("Conta mesmo nome");
	}
	public void salvar() {
		clickByText("SALVAR");
	}
}
