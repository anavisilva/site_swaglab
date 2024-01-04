package com.saucedemo.sl.PageObject;

import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    private static final String URL_LOGIN = "https://www.saucedemo.com/";

    public LoginPage() {
        //Abrir o chrome
        super(null);
        //Abrir o site do swaglab
        this.navegador.get(URL_LOGIN);
    }

    public void preencheFormularioDeLogin(String username, String password) {
        // Digitar o username no campo com ID igual a user-name
        navegador.findElement(By.id("user-name")).sendKeys(username);

        //Digitar password no campo com ID igual a password
        navegador.findElement(By.id("password")).sendKeys(password);

    }

    public ProductPage efetuaLogin() {
        navegador.findElement(By.id("login-button")).click();
        return new ProductPage(navegador);
    }

    public boolean isPaginaDeLogin() {
        return navegador.getCurrentUrl().equals(URL_LOGIN);
    }

    public boolean contemMensagemDeErro(String mensagem) {
        return navegador.getPageSource().contains(mensagem);
    }

    public void navegaParaPaginaDeCompras() {
        this.navegador.get("https://www.saucedemo.com/inventory.html");
    }

    public boolean contemTexto(String texto) {
        return navegador.getPageSource().contains(texto);
    }
}
