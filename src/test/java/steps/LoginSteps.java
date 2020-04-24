package steps;

import data.DataYaml;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();


    @Dado("eu estou na pagina de login")
    public void eu_estou_na_pagina_de_login() {
        loginPage.acessaAplicacao();
        Assert.assertTrue(loginPage.isPresentLoginPage());
    }

    @Quando("eu efetuar o login com credencias validas")
    public void eu_efetuar_o_login_com_credencias_validas() {
        loginPage.executaLogin(DataYaml.getMapYamlValues("Usuarios","credenciais_validas"));
    }

    @Entao("sera apresentado a tela do menu principal")
    public void sera_apresentado_a_tela_do_menu_principal() {
        Assert.assertTrue(homePage.isPresentHomePage());
    }
}
