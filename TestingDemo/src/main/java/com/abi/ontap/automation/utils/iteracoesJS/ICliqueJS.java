package com.abi.ontap.automation.utils.iteracoesJS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.abi.ontap.automation.utils.driver.DriverWeb;
import com.abi.ontap.automation.utils.iteracoesWeb.IEncontraTipoElementoWeb;


public interface ICliqueJS extends IEncontraTipoElementoWeb{
	/**
	 * @Descricao Clicar no elemento
	 * @param elemento
	 */
	default void clicarJavascript(String elemento) {
		WebElement element = encontra(elemento);
		JavascriptExecutor executor = (JavascriptExecutor) DriverWeb.getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

}