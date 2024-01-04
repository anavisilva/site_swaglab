package com.saucedemo.sl.tests;

import com.saucedemo.sl.PageObject.LoginPage;
import org.junit.jupiter.api.*;

@DisplayName("Testes Automatizados da Funcionalidade de Login")
public class LoginTests {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach() {
        this.paginaDeLogin = new LoginPage();
    }

    @Test
    @DisplayName("Login de usuário com dados válidos")
    public void testLoginDeUsuarioComDadosValidos() {

        paginaDeLogin.preencheFormularioDeLogin("standard_user", "secret_sauce");
        paginaDeLogin.efetuaLogin();

        Assertions.assertFalse(paginaDeLogin.isPaginaDeLogin());
    }

    @Test
    @DisplayName("Login com usuário inválido")
    public void testLoginComUsuarioInvalido() {

        paginaDeLogin.preencheFormularioDeLogin("usuarioinvalido", "secret_sauce");
        paginaDeLogin.efetuaLogin();

        Assertions.assertTrue(paginaDeLogin.contemMensagemDeErro("Epic sadface: Username and password " +
                "do not match any user in this service"));
    }

    @Test
    @DisplayName("Login com senha invalida")
    public void testLoginComSenhaInvalida () {

        paginaDeLogin.preencheFormularioDeLogin("standard_user", "123456");
        paginaDeLogin.efetuaLogin();

        Assertions.assertTrue(paginaDeLogin.contemMensagemDeErro("Epic sadface: Username and password " +
                "do not match any user in this service"));
    }

    @Test
    @DisplayName("Login com username em branco")
    public void testLoginComUsernameEmBranco () {

        paginaDeLogin.preencheFormularioDeLogin("", "secret_sauce");
        paginaDeLogin.efetuaLogin();

        Assertions.assertTrue(paginaDeLogin.contemMensagemDeErro("Epic sadface: Username is required"));
    }

    @Test
    @DisplayName("Login com password em branco")
    public void testLoginComPasswordEmBranco () {

        paginaDeLogin.preencheFormularioDeLogin("standard_user", "");
        paginaDeLogin.efetuaLogin();

        Assertions.assertTrue(paginaDeLogin.contemMensagemDeErro("Epic sadface: Password is required"));
    }

    @Test
    @DisplayName("url restrita")
    public void testUrlRestritaParaUsuarioQueNaoEstaLogado () {

        paginaDeLogin.navegaParaPaginaDeCompras();

        Assertions.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assertions.assertFalse(paginaDeLogin.contemTexto("Products"));
    }

}
