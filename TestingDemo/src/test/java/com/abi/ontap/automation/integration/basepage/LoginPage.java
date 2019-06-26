package com.abi.ontap.automation.integration.basepage;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.abi.ontap.automation.integration.stepdefs.LoginSteps;
import com.abi.ontap.automation.utils.driver.DriverWeb;
import com.abi.ontap.automation.utils.iteracoesWeb.InteracaoSeleniumJavaWeb;


public class LoginPage extends InteracaoSeleniumJavaWeb {

	public static String url = "https://test.salesforce.com";
	public static String user = "username";
	public static String password = "password";
	public static String botaoEntrar = "Login";
	public static String urlInicio = "https://abiafrica--afrdev.lightning.force.com/lightning/o/Contact/list?filterName=Recent";
	public static String escreverUser = "bdrqauser@everis.com.afrdev";
	public static String escreverPassword = "test@2020";
	public LoginPage(WebDriver driver) throws IOException {
		super(driver);
		
	}

	public void telaLogin() {
		System.out.println(url);
		abrirUrl(url);
	}

	public void formularioLogin() throws InterruptedException {
		Thread.sleep(5000);
		escrever(user, escreverUser);
		escrever(password, escreverPassword);
	}

	public void botaoEntrar() {
		
		clicar(botaoEntrar);
	}

	public void paginaInicial() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(urlInicio);
		validarUrlAtual(urlInicio);
	}

	public void bloqueiaBotaoEntrar() {
		boolean botaoEntrarHabilitado = VerificarElementoEstaHabilitado(botaoEntrar);

		if (!botaoEntrarHabilitado) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Botão 'Entrar' está habilitado!");
		}
	}




	public static void loginGeral() throws Throwable {
		try {
			LoginSteps login = new LoginSteps();
			login.that_I_m_logged_in();

			// if (DriverWeb.getDriver().getCurrentUrl().contains("login") &&
			// !DriverWeb.getDriver().findElements(By.name(escreverCPF)).isEmpty())
			// {
			if (DriverWeb.getDriver().getCurrentUrl().contains("login")) {
				System.out.println("Fazer Login");
				login.i_fill_out_the_login_form();
				login.i_activate_the_button_Login();
				login.the_user_is_redirected_to_the_home_page();
			} else {
				System.out.println("Ja esta logado");
				Thread.sleep(5000);
			}

			/*
			 * if (!DriverWeb.getDriver().getCurrentUrl().contains("login")) {
			 * System.out.println("Ja esta logado"); Thread.sleep(5000); } else
			 * { System.out.println("Fazer Login");
			 * login.preencho_o_formulario_de_login();
			 * login.aciono_o_botao_Entrar();
			 * login.o_usuario_e_redirecionado_para_a_pagina_inicial(); }
			 */
		} catch (Exception e) {
			fail("Dados de login inválidos!");
		}

	}
	

}

