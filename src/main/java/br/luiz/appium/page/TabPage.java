package br.luiz.appium.page;

import br.luiz.appium.core.BasePage;
import org.openqa.selenium.By;

public class TabPage extends BasePage {

    public void clickTabTwo(){
        clickByText("ABA 2");
    }

    public String getMessageTab(){
        return getText(By.xpath("//*[starts-with(@text, 'Este é o conteúdo')]"));
    }
    public boolean isAba1(){
        return isExisteElementoPorTexto("Este é o conteúdo da Aba 1");
    }

    public boolean isAba2(){
        return isExisteElementoPorTexto("Este é o conteúdo da Aba 2");
    }


}
