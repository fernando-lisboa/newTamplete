package com.abi.ontap.automation.utils.iteracoesWeb;

import org.openqa.selenium.interactions.Actions;

import com.abi.ontap.automation.utils.driver.DriverWeb;

public interface IArrastar extends IEncontraTipoElementoWeb{
	Actions action = new Actions(DriverWeb.getDriver());
	
	default void arrastar(String elemento, String elemento2) {
		try {
			action.dragAndDrop(encontra(elemento), encontra(elemento2));
			action.perform();
		} catch (Exception e) {
			String valorError = "Não é um elemento de arraste";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}
}