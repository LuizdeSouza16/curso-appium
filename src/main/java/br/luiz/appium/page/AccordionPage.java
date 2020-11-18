package br.luiz.appium.page;

import br.luiz.appium.core.BasePage;

public class AccordionPage extends BasePage {

    public void selectOption1(){
        clickByText("Opção 1");
    }

    public boolean isOpcao1(){
        return isExisteElementoPorTexto("Esta é a descrição da opção 1");
    }

}
