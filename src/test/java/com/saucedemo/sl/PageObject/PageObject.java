package com.saucedemo.sl.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

    protected WebDriver navegador;



    public PageObject(WebDriver navegador) {
        //Abrir o chrome
        if (navegador == null) {
            this.navegador = new ChromeDriver();
        } else {
            this.navegador = navegador;
        }
    }

    public void fechar() {
        //Fechar o navegador
        this.navegador.quit();
    }
}
