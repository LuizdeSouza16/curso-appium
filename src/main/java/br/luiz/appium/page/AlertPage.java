package br.luiz.appium.page;

import br.luiz.appium.core.BasePage;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {

    public void clickConfirm(){
        clickByText("ALERTA CONFIRM");
    }

    public String getMsgAlert(){
        return getText(By.id("android:id/message"));
    }

    public String getTitleAlert(){
        return getText(By.id("android:id/alertTitle"));
    }

    public void clickConfirmAlert(){
        clickByText("CONFIRMAR");
    }

    public void clickExit(){
        clickByText("SAIR");
    }

    public void clickSimple() {
        clickByText("ALERTA SIMPLES");
    }

    public void clickForaAlert(int x, int y){
        tap(x,y);
    }

}
