package com.saucedemo.sl.tests;

import com.saucedemo.sl.PageObject.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@DisplayName("Testes Automatizados da funcionalidade compra")
public class CompraTests {
    protected WebDriver navegador;
    private ProductPage paginaDeCompra;
    private CarrinhoPage yourCart;

    private CheckoutPage checkout;
    private CheckoutOverviewPage checkoutOverview;

    private CheckoutCompletePage checkoutComplete;

    @Test
    @DisplayName("Adicionar um produto ao carrinho")
    public void testRegistroDeProdutoNoCarrinho() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioDeLogin("standard_user", "secret_sauce");
        this.paginaDeCompra = paginaDeLogin.efetuaLogin();
        paginaDeCompra.adicionarprodutoaocarrinho("Sauce Labs Backpack");
        paginaDeCompra.clicaNoBotaoDeCarrinho();
        this.yourCart = paginaDeCompra.clicaNoBotaoDeCarrinho();
        yourCart.clicaNoBotaoCheckout();
        this.checkout = new CheckoutPage(navegador);
        checkout.preencheFormularioDeEnvio("Ana", "Silva", "58400333");
        checkoutOverview.finalizaCompra();
        Assertions.assertTrue(checkoutComplete.contemTexto("Thank you for your order!"));
//        String firstName = "Ana";
//        String lastName = "Silva";
//        String postalCode = "58400333";
    }
}
