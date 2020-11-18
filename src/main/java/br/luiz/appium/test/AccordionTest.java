package br.luiz.appium.test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.AccordionPage;
import br.luiz.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTest  extends BaseTest {
    private MenuPage menu = new MenuPage();
    private AccordionPage accordion = new AccordionPage();

    @Test
    public void interagirAccordium(){
        menu.accessAccordion();
        accordion.selectOption1();
        Assert.assertTrue(accordion.isOpcao1());
    }
}
