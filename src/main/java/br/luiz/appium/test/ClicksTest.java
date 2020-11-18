package br.luiz.appium.test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.ClickPage;
import br.luiz.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class ClicksTest extends BaseTest {

    private final MenuPage menu = new MenuPage();
    private final ClickPage clique  = new ClickPage();

    @Test
    public void cliqueLongo(){
        menu.accessCliques();
        clique.cliqueLongo("Clique Longo");
        Assert.assertEquals("Clique Longo", clique.obterTexto());

    }

    @Test
    public void cliqueDuplo(){
        menu.accessCliques();
        clique.CliqueDuplo();

        Assert.assertEquals("Duplo Clique", clique.obterTexto());
    }
}

