package com.abi.ontap.automation.utils.iteracoesWeb;


import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.abi.ontap.automation.utils.iteracoesJS.ICliqueJS;
import com.abi.ontap.automation.utils.iteracoesJS.IEscreverJS;
import com.abi.ontap.automation.utils.iteracoesJS.IMoverJS;
import com.abi.ontap.automation.utils.iteracoesJS.IObterJS;
import com.abi.ontap.automation.utils.iteracoesJS.IRolarJS;



/**
 * @author Paulo Lobo Neto
 * @Descricao Classe responsável por conter comandos que executam interações com
 *            a página da web. Os métodos contidos na classe são todos públicos
 *            e para utilizá-la, é necessário passar o WebDriver como parâmetro
 */
public class InteracaoSeleniumJavaWeb implements IAlert, IAcoesBrowser, IArrastar, IClique, ICliqueJS, ICombo,
		IEscrever, IEscreverJS, IEspera, IFrame, ILimpar, IMover, IMoverJS, IObter, IObterJS, IProcurar, IRolarJS,
		IEncontraTipoElementoWeb, IValidacoesWeb {

	public static String nomePlataformaDeExecucao;

	public InteracaoSeleniumJavaWeb(WebDriver webDriver) {

	}
	
	/**
	 * @author Felipe Lourenço
	 * @Descricao Esperar o GIF desaparecer da tela
	 * 
	 */
	
	public void aguardarGif(String elemento) {
		boolean isVisible = verificarElementExibido(elemento);

		try {
			while (isVisible) {
				isVisible = verificarElementExibido(elemento);

				if (!isVisible) {
					System.out.println("tela carregada");
					break;
				}
			}
		} catch (Exception exc) {
			System.out.println("Gif não encontrado");
		}
	}

	/**
	 * @author Felipe Lourenço
	 * @Descricao Alterar CNPJ do campo Estabelecimento
	 * @param elemento
	 *            elemento do GIF, clica no combo e clica no Estabelecimento
	 *            especifico.
	 */

	public void alterarCNPJ(String elemento1, String elemento2, String elemento3)
			throws IOException, InterruptedException {
		aguardarGif(elemento1);
		clicar("id", elemento2);
		Thread.sleep(5000);
		clicar("xpath", elemento3);
	}
	/**
	 * @author Felipe Lourenço
	 * @Descricao Alterar CNPJ do campo Estabelecimento
	 * @param elemento
	 *            elemento do GIF, clica no combo e clica no Estabelecimento
	 *            especifico.
	 */

	public void alterarCNPJArv(String elemento,String elemento3)
			throws IOException, InterruptedException {
		clicar("id", elemento);
		Thread.sleep(5000);
		clicar("xpath", elemento3);
	}
}
