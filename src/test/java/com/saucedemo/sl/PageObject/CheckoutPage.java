package com.saucedemo.sl.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends  PageObject{

    private static final String URL_CHECKOUT = "https://www.saucedemo.com/checkout-step-one.html";

    public CheckoutPage (WebDriver navegador) {
        super(navegador);
    }

    public CheckoutOverviewPage preencheFormularioDeEnvio(String firstName, String lastName, String postalCode) {
        this.navegador.findElement(By.name("firstName")).sendKeys(firstName);
        this.navegador.findElement(By.cssSelector("input[id='last-name']")).sendKeys(lastName);
        this.navegador.findElement(By.cssSelector("input[id='postal-code']")).sendKeys(postalCode);
        this.navegador.findElement(By.cssSelector("input[id='continue']")).click();
        return new CheckoutOverviewPage(navegador);

  }
}
