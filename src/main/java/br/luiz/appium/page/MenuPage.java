package br.luiz.appium.page;

import br.luiz.appium.core.BasePage;

public class MenuPage extends BasePage {

    public void accessForm(){
        clickByText("Formulário");
    }

    public void accessSplash(){
        clickByText("Splash");
    }

    public void accessAlert(){
        clickByText("Alertas");
    }

    public void accessTabs(){
        clickByText("Abas");
    }
}
