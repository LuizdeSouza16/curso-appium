package br.luiz.appium.test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.MenuPage;
import br.luiz.appium.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

public class SplashTest extends BaseTest {
    private MenuPage menu = new MenuPage();
    private SplashPage splash = new SplashPage();

    @Test
    public void deveAguardarSplashSumir(){
        //acessar menu splash
        menu.accessSplash();
        //verificar se splash está sendo exibido
        splash.isTelaSplashVisivel();
        //aguardar splash saindo
        splash.aguardarSplashSumir();
        // verificar formulario aparecendo
        Assert.assertTrue(splash.isExisteElementoPorTexto("Formulário"));
    }
}
