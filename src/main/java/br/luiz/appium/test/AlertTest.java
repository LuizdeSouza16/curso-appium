package br.luiz.appium.test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.MenuPage;
import br.luiz.appium.page.AlertPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlertTest extends BaseTest {
    private MenuPage menu = new MenuPage();
    private AlertPage alert = new AlertPage();

    @Before
    public void acessarAlerta(){
        menu.accessAlert();
    }
    @Test
    public void deveConfirmar(){
        alert.clickConfirm();

        String title = alert.getTitleAlert();

        Assert.assertEquals("Info", title);
        Assert.assertEquals("Confirma a operação?", alert.getMsgAlert());

        alert.clickConfirmAlert();

        Assert.assertEquals("Confirmado", alert.getMsgAlert());

        alert.clickExit();
    }

    @Test
    public void clickarForaAlerta(){
        alert.clickSimple();
        alert.clickForaAlert(206, 141);
        Assert.assertFalse(alert.isExisteElementoPorTexto("Pode clicar OK ou fora da caixa para sair"));

    }
}
