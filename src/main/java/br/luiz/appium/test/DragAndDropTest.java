package br.luiz.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.DragAndDropPage;
import br.luiz.appium.page.MenuPage;

public class DragAndDropTest extends BaseTest{

	private MenuPage menu = new MenuPage();
	private DragAndDropPage page = new DragAndDropPage();
	
	
	private String[] estadoInicial = new String[] {
			"Esta", "é uma lista",
			"Drag em Drop!",
			"Faça um clique longo,", 
			"e arraste para", 
			"qualquer local desejado."
	};
	
	@Test
	public void deveEfetuarDragAndDrop() {
		menu.accessDragAndDrop();
		Assert.assertArrayEquals(estadoInicial, page.getLista());
		page.arrastar("Esta", "e arraste para");
		page.arrastar("qualquer local desejado.", "Drag em Drop!");
		
	}
}
