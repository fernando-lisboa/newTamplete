package com.abi.ontap.automation.integration.stepdefs;

import java.io.IOException;

import com.abi.ontap.automation.integration.basepage.LoginPage;
import com.abi.ontap.automation.utils.driver.DriverWeb;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends LoginPage {
	
	public LoginSteps() throws IOException {
		super(DriverWeb.getDriver());
	}
	
	@Given("that I'm logged in")
	public void that_I_m_logged_in() throws Throwable {
		LoginPage.loginGeral();
	}

	@Given("I'm in login screen")
	public void i_m_in_login_screen() {
		telaLogin();
	}

	@Given("I fill out the login form")
	public void i_fill_out_the_login_form() throws InterruptedException {
		formularioLogin();
	}

	@When("I activate the button Login")
	public void i_activate_the_button_Login() {
		esperarSerClicavel("Login", 5);
		botaoEntrar();
	}

	@Then("the user is redirected to the home page")
	public void the_user_is_redirected_to_the_home_page() throws InterruptedException {
		paginaInicial();
	}
	
	


}
