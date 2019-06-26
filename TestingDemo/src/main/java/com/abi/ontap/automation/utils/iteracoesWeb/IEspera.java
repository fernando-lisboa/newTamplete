package com.abi.ontap.automation.utils.iteracoesWeb;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.abi.ontap.automation.utils.driver.DriverWeb;

public interface IEspera extends IEncontraTipoElementoWeb {
	Log logger = LogFactory.getLog(IEspera.class);
	
	/**
	 * @param       elemento.
	 * @param tempo limite de espera
	 */
	default void esperarSerClicavel(String elemento, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), time);
			wait.until(ExpectedConditions.elementToBeClickable(encontra(elemento)));
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}
	
	/**
	 * @param       elemento.
	 * @param tempo limite de espera
	 */
	default void esperarSerClicavel(String propriedade, String elemento, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), time);
			wait.until(ExpectedConditions.elementToBeClickable(encontra(propriedade, elemento)));
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	default void esperarSerSelecionavel(String elemento, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), time);
			wait.until(ExpectedConditions.elementToBeSelected(encontra(elemento)));
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao Esperar a página estar na URL passada via parâmetro
	 * @param URL
	 * @param tempoLimiteDeEspera
	 */
	default void esperarUrlSerCarregada(String url, int tempoLimiteDeEspera) {
		WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoLimiteDeEspera);
		wait.until(ExpectedConditions.urlToBe(url));
	}

	/**
	 * @Descricao Esperar elemento ser clicável, clicar e escrever
	 * @param elemento
	 * @param texto
	 * @param tempoLimiteDeEspera
	 */
	default void esperarSerClicavelClicarEscrever(String elemento, String valor, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoLimiteDeEspera);
			wait.until(ExpectedConditions.elementToBeClickable(encontra(elemento))).clear();
			wait.until(ExpectedConditions.elementToBeClickable(encontra(elemento))).click();
			wait.until(ExpectedConditions.elementToBeClickable(encontra(elemento))).sendKeys(valor);
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}
	
	/**
	 * @param elemento
	 * @param tempo    limite de espera
	 */
	default void esperarElemento(String elemento, int time) {
		try {
			logger.info(
					" -- Realizar acao de esperar o elemento: " + elemento + " pelo tempo de:" + time + " segundos.");

			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), time);
			wait.until(ExpectedConditions.visibilityOf(encontra(elemento)));
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao Esperar visibilidade do elemento
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	default void esperarVisibilidadeDoElemento(String elemento, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoLimiteDeEspera);
			wait.until(ExpectedConditions.visibilityOf(encontra(elemento)));
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao Esperar elemento ser visível
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	default void esperarElementoSerVisivel(String elemento, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoLimiteDeEspera);
			wait.until(ExpectedConditions.visibilityOf(encontra(elemento)));
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao Esperar elemento ser clicável, após, limpar o campo
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	default void esperarElementoSerClicavelLimparCampo(String elemento, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoLimiteDeEspera);
			WebElement input = wait.until(ExpectedConditions.elementToBeClickable(encontra(elemento)));
			while (input.getAttribute("value").length() > 0) {
				input.sendKeys(Keys.BACK_SPACE);
			}
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}
}