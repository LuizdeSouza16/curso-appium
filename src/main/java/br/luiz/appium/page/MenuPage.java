package br.luiz.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.luiz.appium.core.BasePage;
import br.luiz.appium.core.DriverFactory;

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

    public void accessAccordion(){
        clickByText("Accordion");
    }

    public void accessCliques(){
        clickByText("Cliques");
    }
    
    public void accessSwipe(){
        clickByText("Swipe");
    }
    
    public void accessSwipeList(){
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
    			
		scrollDown();
    			
        clickByText("Swipe List");
    }
    
    public void accessDragAndDrop(){
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
    			
		scrollDown();
    			
        clickByText("Drag and drop");
    }
    
    public void accessSrBarrigaHibrido(){
        clickByText("SeuBarriga Híbrido");
    }

}
