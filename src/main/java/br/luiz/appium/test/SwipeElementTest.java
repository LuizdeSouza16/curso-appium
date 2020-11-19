package br.luiz.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.MenuPage;
import br.luiz.appium.page.SwipeListPage;


public class SwipeElementTest extends BaseTest {

	private  MenuPage menu = new MenuPage();
	private SwipeListPage swipeList = new SwipeListPage();
	@Test
	public void resolverDesafio() {
			
		menu.accessSwipeList();
		
		swipeList.swipeElementRight("Opção 1");
		swipeList.clickarBotaoMais();;
		Assert.assertTrue(swipeList.isExisteElementoPorTexto("Opção 1 (+)"));
		
		swipeList.swipeElementRight("Opção 4");
		swipeList.clickByText("(-)");
		Assert.assertTrue(swipeList.isExisteElementoPorTexto("Opção 4 (-)"));
		
		swipeList.swipeElementLeft("Opção 5 (-)");
		Assert.assertTrue(swipeList.isExisteElementoPorTexto("Opção 5"));
		
	}
}

