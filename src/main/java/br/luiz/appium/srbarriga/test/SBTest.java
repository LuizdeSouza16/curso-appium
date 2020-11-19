package br.luiz.appium.srbarriga.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.MenuPage;
import br.luiz.appium.srbarriga.page.SBLoginPage;

public class SBTest extends BaseTest{
	
	private SBLoginPage login = new SBLoginPage();
	private MenuPage menu = new MenuPage();
	
	@Before
	public void login() {
		menu.clickByText("SeuBarriga Nativo");
		login.setLogin();
		login.setSenha();
		login.entrar();
		Assert.assertTrue(login.isExisteElementoPorTexto("RESET"));
		login.clickByText("RESET");
	}
	
	@Test
	public void cadastarConta() {
		
	}

}
