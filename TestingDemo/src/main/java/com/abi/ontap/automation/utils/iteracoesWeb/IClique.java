package com.abi.ontap.automation.utils.iteracoesWeb;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import com.abi.ontap.automation.utils.driver.DriverWeb;

public interface IClique extends IEncontraTipoElementoWeb {
	Log logger = LogFactory.getLog(IClique.class);
	Actions action = new Actions(DriverWeb.getDriver());

	/**
	 * @Descricao Clicar em um ou mais elementos
	 * @param elementos
	 */
	default void clicarElementos(List<String> elementos) {
		int posicaoElemento = 0;
		try {
			for (int i = 0; i <= elementos.size(); i++) {
				posicaoElemento = i;
				logger.info(" -- Realizar acao de clicar no elemento: " + elementos.get(i));
				encontra(elementos.get(i)).click();
			}
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elementos.get(posicaoElemento).toString()
					+ "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. NAO foi possivel localizar o elemento: '"
					+ elementos.get(posicaoElemento).toString() + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elementos.get(posicaoElemento).toString()
					+ "' na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. Tempo excedido para encontrar elemento: '"
					+ elementos.get(posicaoElemento).toString() + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elementos.get(posicaoElemento).toString()
					+ "' NAO esta visivel na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elementos.get(posicaoElemento).toString() + "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao Clicar em um elemento
	 * @param elemento
	 */
	default void clicar(String elemento) {
		try {
			logger.info(" -- Realizar acao de clicar no elemento: " + elemento);
			encontra(elemento).click();
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
	 * @Descricao Clicar em um elemento informando que tipo de propriedade gostaria que procurasse primeiro
	 * @param propriedade
	 * @param elemento
	 */
	default void clicar(String propriedade, String elemento) {
		try {
			logger.info(" -- Realizar acao de clicar no elemento: " + elemento);
			encontra(propriedade, elemento).click();
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
	 * @param elemento
	 */
	default void duploCliqueNoElemento(String elemento) {
		try {
			logger.info(" -- Realizar acao de duplo clique no elemento: " + elemento);
			action.doubleClick(encontra(elemento));
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

	default void duploClique() {
		action.doubleClick();

	}
}