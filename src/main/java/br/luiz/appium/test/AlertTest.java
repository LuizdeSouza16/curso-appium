package br.luiz.appium.test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.MenuPage;
import br.luiz.appium.page.PageAlerts;
import org.junit.Assert;
import org.junit.Test;

public class AlertTest extends BaseTest {
    private MenuPage menu = new MenuPage();
    private PageAlerts alert = new PageAlerts();

    @Test
    public void deveConfirmar(){
        // deve acessar o menu alerta
        menu.accessAlert();
        // clickar em alerta confirm
        alert.clickConfirm();
        //confirmar alerta
        String title = alert.getTitleAlert();

        Assert.assertEquals("Info", title);
        Assert.assertEquals("Confirma a operação?", alert.getMsgAlert());
        alert.clickConfirmAlert();
        // verificar nova mensagem
        Assert.assertEquals("Confirmado", alert.getMsgAlert());
        //sair
        alert.clickExit();
    }
}
