package br.luiz.appium.page;

import br.luiz.appium.core.DSL;

public class MenuPage {

    private static  DSL dsl = new DSL();

    public void accessForm(){
        dsl.clickByText("Formulário");
    }
}
