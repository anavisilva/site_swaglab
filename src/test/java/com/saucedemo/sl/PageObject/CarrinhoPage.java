package com.saucedemo.sl.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage extends PageObject{
    private static final String URL_CARRINHO = "https://www.saucedemo.com/cart.html";

    public CarrinhoPage(WebDriver navegador) {
        super(navegador);
    }

    public CheckoutPage clicaNoBotaoCheckout() {
        this.navegador.findElement(By.cssSelector("button[id='checkout']")).click();
        return new CheckoutPage(navegador);
    }
}
