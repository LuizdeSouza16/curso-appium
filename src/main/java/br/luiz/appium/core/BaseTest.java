package br.luiz.appium.core;

import org.junit.After;
import org.junit.AfterClass;

public class BaseTest {
    @After
    public void tearDown(){
        DriverFactory.getDriver().resetApp();
    }

    @AfterClass
    public static void closeApp(){
        DriverFactory.killDriver();
    }
}
