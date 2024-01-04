package com.saucedemo.sl.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends PageObject {

    private static final String URL_CARRINHO = "https://www.saucedemo.com/cart.html";


    public ProductPage(WebDriver navegador) {
        //Abrir o chrome
        super(navegador);
    }

    public void adicionarprodutoaocarrinho(String item) {
        List<WebElement> items = navegador.findElements(By.cssSelector("div[class='inventory_item']"));
        for (WebElement iten : items) {
            String itemNameString = iten.findElement(By.cssSelector("div[class='inventory_item_name']")).getText();

            if (itemNameString.contains(item)) {
                iten.findElement(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory']")).click();
            }
        }
    }

    public CarrinhoPage clicaNoBotaoDeCarrinho() {
        navegador.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();
        return new CarrinhoPage(navegador);

    }
}



