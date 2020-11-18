package br.luiz.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.MenuPage;

public class SwipeTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveRealizarSwipe() {
		menu.accessSwipe();
		
		Assert.assertTrue(menu.isExisteElementoPorTexto("a esquerda"));
		
		menu.swipeRight();
		
		Assert.assertTrue(menu.isExisteElementoPorTexto("E veja se"));
		
		menu.clickByText("›");
		
		Assert.assertTrue(menu.isExisteElementoPorTexto("Chegar até o fim!"));
		
		menu.swipeLeft();
		
		Assert.assertTrue(menu.isExisteElementoPorTexto("E veja se"));
		
		menu.clickByText("‹");
		
		Assert.assertTrue(menu.isExisteElementoPorTexto("a esquerda"));
		
	}
	
}
