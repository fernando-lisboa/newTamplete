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


public interface ILimpar extends IEncontraTipoElementoWeb {

	Log logger = LogFactory.getLog(ILimpar.class);

	/**
	 * @Descricao Limpar campo
	 * @param elemento
	 * @param texto
	 */
	default void limpar(String elemento, String texto) {
		try {
			logger.info(" -- Realizar acao de limpar o elemento: " + elemento);
			encontra(elemento).clear();
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. NAO foi possivel localizar o elemento: '"
					+ elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. Tempo excedido para encontrar elemento: '"
					+ elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao limpar valor com backspace
	 * @param elemento
	 */
	default void limparValorComBackspace(WebElement elemento) {
		try {
			while (elemento.getAttribute("value").length() > 0) {
				logger.info(" -- Realizar acao de limpar o valor do: " + elemento + " com BACKSPACE");
				elemento.sendKeys(Keys.BACK_SPACE);
			}
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. NAO foi possivel localizar o elemento: '"
					+ elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. Tempo excedido para encontrar elemento: '"
					+ elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao Limpar Campo
	 * @param elemento
	 */
	default void limparCampo(String elemento) {
		try {
			logger.info(" -- Realizar acao de limpar o campo do elemento: " + elemento);
			encontra(elemento).clear();
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. NAO foi possivel localizar o elemento: '"
					+ elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. Tempo excedido para encontrar elemento: '"
					+ elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
	}
}