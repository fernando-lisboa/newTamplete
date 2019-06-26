package com.abi.ontap.automation.utils.iteracoesJS;

import org.openqa.selenium.JavascriptExecutor;

import com.abi.ontap.automation.utils.driver.DriverWeb;

public interface IRolarJS {
	/**
	 * @Descricao Rolar para baixo. O parâmetro "quantidade" define a quantidade de
	 *            rolagens
	 * @param quantidade
	 */
	default void rolarParaBaixoJavascript(int quantidade) {
		JavascriptExecutor jse = (JavascriptExecutor) DriverWeb.getDriver();
		jse.executeScript("window.scrollBy(0, " + quantidade + ")");
	}

	/**
	 * @Descricao Rolar para cima. O parâmetro "quantidade" define a quantidade de
	 *            rolagens
	 * @param quantidade
	 */
	default void rolarParaCimaJavascript(int quantidade) {
		JavascriptExecutor jse = (JavascriptExecutor) DriverWeb.getDriver();
		jse.executeScript("window.scrollBy(0, " + quantidade + ")");
	}
}