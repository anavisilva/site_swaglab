package com.saucedemo.sl.PageObject;

import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends PageObject{
    private static final String URL_CHECKOUTCOMPLETE ="https://www.saucedemo.com/checkout-complete.html";

    public CheckoutCompletePage (WebDriver navegador) {
        super(null);
    }

    public boolean contemTexto(String texto) {
       return navegador.getPageSource().contains(texto);
   }
}
