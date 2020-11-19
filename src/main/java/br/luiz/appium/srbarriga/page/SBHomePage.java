package br.luiz.appium.srbarriga.page;

import br.luiz.appium.core.BasePage;

public class SBHomePage extends BasePage{
	
	public void reset() {
		clickByText("RESET");
	}
	
	public void accessContas(){
		clickByText("CONTAS");
	}
	
	public void accessMov(){
		clickByText("MOV...");
	}
	
	public void accessResumo(){
		clickByText("RESUMO");
	}

}
