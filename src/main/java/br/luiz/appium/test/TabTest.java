package br.luiz.appium.test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.MenuPage;
import br.luiz.appium.page.TabPage;
import org.junit.Assert;
import org.junit.Test;

public class TabTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private TabPage tab = new TabPage();

    @Test
    public void deveInteragirComAbas(){
        // acessar menu abas
        menu.accessTabs();
        //verificar aba1
       Assert.assertEquals("Este é o conteúdo da Aba 1", tab.getMessageTab());
        //acessar aba2
        tab.clickTabTwo();
        //verificar aba2
        //Assert.assertEquals("Este é o conteúdo da Aba 2", tab.getMessageTab());
    }
}
