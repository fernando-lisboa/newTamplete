package com.abi.ontap.automation.integration;



import org.junit.runner.RunWith;

import com.abi.ontap.automation.utils.anotations.AfterSuite;
import com.abi.ontap.automation.utils.anotations.BeforeSuite;
import com.abi.ontap.automation.utils.anotations.ExtendedCucumberRunner;
import com.abi.ontap.automation.utils.driver.DriverWeb;

import cucumber.api.CucumberOptions;


/**
 * @version = 1.3
 * @author Paulo Lobo Neto
 * @CucumberExecuteTest = Classe principal, responsavel pelo gerenciamento e
 *                      execucao dos testes.
 * @RunWith = Quando uma classe e anotada com RunWith, JUnit invocara a classe
 *          referenciada para executar os testes.
 * @Features = caminho dos arquivos ".features".
 * @Glue = Caminho das classes de definicao dos passos (steps). Obs.: se nao for
 *       especificado a pasta, ele procura em toda a estrutura.
 * @DryRun = Se "true", verifica se todos os passos definidos nas features estao
 *         implementados.
 * @Strict = Se "true", falha a execucao dos testes caso tenha passos
 *         indefinidos ou pendentes.
 * @Plugin = Define os diversos relatorios que serao gerados.
 * @Tags = manipular tags dos ".features". Exemplo para rodar uma tag
 *       especifica: tags = {"@tag"}. Mais de uma tag: tags = {"@tag1","@tag2"}.
 *       Nao rodar uma tag especifica: tags ={"~@tag"}
 */

@RunWith(ExtendedCucumberRunner.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {
		"json:src/test/resources/cucumber-report/Resultado.json", "rerun:src/test/resources/falhas/rerun.txt",
		"junit:src/test/resources/junit-report/Resultado.xml", "html:src/test/resources/cucumber-report/" },

		tags = { "@loginInicial" }, 
		glue = { "com.abi.ontap.automation.integration.stepdefs" },
		monochrome = true, dryRun = false, strict = false)

public class RunnerCucumberWebTest {

	@BeforeSuite
	public static void metodoInicial() {

	}

	@AfterSuite
	public static void metodoFinal() {
		DriverWeb.killDriver();

	}

	}
