package com.saucedemo.sl.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends PageObject{
    private static final String URL_CHECKOUTOVERVIEW ="https://www.saucedemo.com/checkout-step-two.html";

    public CheckoutOverviewPage (WebDriver navegador){
        super(navegador);
    }

    public void finalizaCompra() {
        //this.navegador.navigate().to(URL_CHECKOUTOVERVIEW);
        this.navegador.findElement(By.id("finish")).click();
   }
}
