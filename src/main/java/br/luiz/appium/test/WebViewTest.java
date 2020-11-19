package br.luiz.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.MenuPage;
import br.luiz.appium.page.WebViewPage;

public class WebViewTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();

	@Test
	public void deveFazerLogin() {
		menu.accessSrBarrigaHibrido();
		page.entarContextoWeb();
		page.setEmail("luiz@luiz.com");
		page.setPass("12345678");
		page.clickEntrar();
		Assert.assertEquals("Bem vindo, Luiz!", page.getMensagem());
		

	}

	@After
	public void tearDown() {
		page.sairContextoWeb();
	}
}
