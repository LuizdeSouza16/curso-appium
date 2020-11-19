package br.luiz.appium.srbarriga.page;

import static br.luiz.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.luiz.appium.core.BasePage;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class ContasPage extends BasePage {

	public void setConta() {
		write(By.xpath("//android.widget.EditText[@text='Conta']"), "Conta para inserir");
	}

	public void salvar() {
		clickByText("SALVAR");
	}

	public void cliqueLongoContaMesmoNome() {
		cliqueLongo("Conta mesmo nome");
	}

	public void cliqueLongo(String valor) {
		AndroidTouchAction touch = new AndroidTouchAction(getDriver());

		touch.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='" + valor + "']")))))
				.perform();
	}
	
	public void clickarExcluir() {
		clickByText("EXCLUIR");
	}
}
