package com.abi.ontap.automation.utils.iteracoesWeb;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import com.abi.ontap.automation.utils.driver.DriverWeb;

public interface IValidacoesWeb extends IEncontraTipoElementoWeb, IObter {
	//Log logger = LogFactory.getLog(InteracaoSeleniumJavaMobileAndroid.class);
	Actions action = new Actions(DriverWeb.getDriver());

	default void validarMensagem(String textoOriginal, String elemento) {
		try {
			String textoDeComparacao = obterTexto(elemento);

			if (textoOriginal.equalsIgnoreCase(textoDeComparacao)) {
				System.out.println("Teste realizado com sucesso.");
			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
			System.out.println(e);
		}
	}
	
	/**
	 * @lucas
	 * @Descricao se a mensagem do atributo value é igual ao passado em parametro
	 */
	default void validarMensagemValue(String textoOriginal, String elemento) {
		try {
			
			String textoDeComparacao = obterValorDoElementoAttribute(elemento, "value");
			if (textoOriginal.equals(textoDeComparacao)) {
				System.out.println("Teste realizado com sucesso.");
			} else {
				System.out.println("Erro. \n" + "Mensagem esperada: " + textoOriginal + "\nMensagem obtida: " + textoDeComparacao);
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
			System.out.println(e);
		}
	}
	
	/**
	 * @author samuel.milani
	 * @Descricao valida se o texto do elemento é igual ao passado em parametro
	 */
	default void validarTextoElemento(String elemento, String textoComparacao) {
		try {
			String textoDeComparacao = obterTextoElemento("id", elemento);
			if (textoComparacao.equalsIgnoreCase(textoDeComparacao)) {
				System.out.println("Teste realizado com sucesso.");
			} else {
				System.out.println("Erro. \n" + "Mensagem esperada: " + textoComparacao + "\nMensagem obtida: " + textoDeComparacao);
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
			System.out.println(e);
		}
	}

	/**
	 * @lucas
	 * @Descricao Valida se o elemento não está na tela
	 */
	default boolean validarNaoExibicaoElemento(String elemento) {
		try {
		DriverWeb.getDriver().findElement(By.id(elemento));
		System.out.println("Elemento: " + elemento + " encontrado");
		return false;
    }catch (Exception e) {
		System.out.println("Elemento: " + elemento + " não encontrado");
		return true;
	}
		}

	/**
	 * @lucas
	 * @Descricao Valida se o elemento não está habilitado
	 */
	default void validarSeElementoNaoEstaHabilitado(String elemento) {
		assertEquals(false, encontra(elemento).isEnabled());
	}
	
	default void validarSeElementoEstaVisivel(String elemento) {
		assertEquals(true, encontra(elemento).isDisplayed());
	}

	default void validarSeElementoEstaHabilitado(String elemento) {
		assertEquals(true, encontra(elemento).isEnabled());
	}

	/**
	 * @Descricao Valida título da aba do browser
	 * @param tituloDaAba
	 */
	default void validarTituloDoBrowser(String tituloDaAba) {
		assertEquals(tituloDaAba, DriverWeb.getDriver().getTitle());
	}

	/**
	 * @Descricao Valida a URL atual
	 * @param URL
	 * 
	 */
	default void validarUrlAtual(String url) {
		assertEquals(url, DriverWeb.getDriver().getCurrentUrl());
	}
	
	/**
	 * @Descricao Valida a URL atual
	 * @param URL
	 * 
	 */
	default boolean validarInicioUrlAtual(String url) {
		if(DriverWeb.getDriver().getCurrentUrl().contains(url)) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * @Descricao Verificar se o Radio Button está selecionado
	 * @param elemento
	 * @return boolean
	 */
	default boolean validarSeElementoEstaSelecionado(String elemento) {
		boolean retorno = false;
		try {
			logger.info(" -- Realizar acao de verificar se radio do elemento: " + elemento + " esta marcado.");
			retorno = encontra(elemento).isSelected();
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
		return retorno;
	}

	/**
	 * @Descricao Verificar se o check box está marcado
	 * @param elemento
	 * @return boolean
	 */
	default boolean validarSeOcheckBoxEstaMarcado(String elemento) {
		boolean retorno = false;
		try {
			retorno = encontra(elemento).isSelected();
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
		return retorno;
	}
	
	public default boolean VerificarElementoEstaHabilitado(String elemento) {
		try {
			System.out.println("verificando elemento habilitado .. " + elemento);

			if (encontra(elemento).isEnabled()) {
				System.out.println("elemento habilitado .. " + elemento);
				return true;
			} else {
				System.out.println(" elemento não está habilitado .. " + elemento);
				return false;
			}
		} catch (Exception e) {
			System.out.println("Elemento não está habilitado");
			return false;
		}
	}
}