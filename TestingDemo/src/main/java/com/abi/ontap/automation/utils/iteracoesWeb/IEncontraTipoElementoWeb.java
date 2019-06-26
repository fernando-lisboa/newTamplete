package com.abi.ontap.automation.utils.iteracoesWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.abi.ontap.automation.utils.driver.DriverWeb;

public interface IEncontraTipoElementoWeb {

	default WebElement encontra(String name) {
		WebElement elemento = null;

		try {
			elemento = DriverWeb.getDriver().findElement(By.id(name));
		} catch (Exception e) {
			try {
				elemento = DriverWeb.getDriver().findElement(By.className(name));
			} catch (Exception e0) {
				try {
					elemento = DriverWeb.getDriver().findElement(By.name(name));
				} catch (Exception e1) {
					try {
						elemento = DriverWeb.getDriver().findElement(By.xpath(name));
					} catch (Exception e2) {
						try {
							elemento = DriverWeb.getDriver().findElement(By.cssSelector(name));
						} catch (Exception e3) {
							try {
								elemento = DriverWeb.getDriver().findElement(By.linkText(name));
							} catch (Exception e4) {
								try {
									elemento = DriverWeb.getDriver().findElement(By.partialLinkText(name));
								} catch (Exception e5) {
									try {
										elemento = DriverWeb.getDriver().findElement(By.tagName(name));
									} catch (Exception e6) {
										String valorError = "Nenhum elemento foi identificado!";
										System.out.println(valorError);
										throw new java.lang.Error(valorError);
									}
								}
							}
						}
					}
				}
			}
		}
		return elemento;
	}

	default WebElement encontra(String propriedade, String name) {
		WebElement elemento = null;

		switch (propriedade.toLowerCase()) {
		case "id":
			try {
				elemento = DriverWeb.getDriver().findElement(By.id(name));
			} catch (Exception e) {
				String valorError = "Nenhum elemento foi identificado por " + propriedade + "!";
				System.out.println(valorError);
				System.out.println("Procurando elemento por outras propriedades...");
				encontra(name);
				throw new java.lang.Error(valorError);
			}
			break;

		case "name":
			try {
				elemento = DriverWeb.getDriver().findElement(By.name(name));
			} catch (Exception e) {
				String valorError = "Nenhum elemento foi identificado por " + propriedade + "!";
				System.out.println(valorError);
				System.out.println("Procurando elemento por outras propriedades...");
				encontra(name);
				throw new java.lang.Error(valorError);
			}
			break;

		case "texto":
			try {
				elemento = DriverWeb.getDriver().findElement(By.linkText(name));
			} catch (Exception e) {
				String valorError = "Nenhum elemento foi identificado por " + propriedade + "!";
				System.out.println(valorError);
				System.out.println("Procurando elemento por outras propriedades...");
				encontra(name);
				throw new java.lang.Error(valorError);
			}
			break;

		case "xpath":
			try {
				elemento = DriverWeb.getDriver().findElement(By.xpath(name));
			} catch (Exception e) {
				String valorError = "Nenhum elemento foi identificado por " + propriedade + "!";
				System.out.println(valorError);
				System.out.println("Procurando elemento por outras propriedades...");
				encontra(name);
				throw new java.lang.Error(valorError);
			}
			break;

		case "cssselector":
			try {
				elemento = DriverWeb.getDriver().findElement(By.cssSelector(name));
			} catch (Exception e) {
				String valorError = "Nenhum elemento foi identificado por " + propriedade + "!";
				System.out.println(valorError);
				System.out.println("Procurando elemento por outras propriedades...");
				encontra(name);
				throw new java.lang.Error(valorError);
			}
			break;

		default:
			encontra(name);
			break;
		}

		return elemento;
	}

	default List<WebElement> encontraElementos(String name) {
		List<WebElement> elemento = null;

		try {
			elemento = DriverWeb.getDriver().findElements(By.id(name));
		} catch (Exception e) {
			try {
				elemento = DriverWeb.getDriver().findElements(By.name(name));
			} catch (Exception e1) {
				try {
					elemento = DriverWeb.getDriver().findElements(By.xpath(name));
				} catch (Exception e2) {
					try {
						elemento = DriverWeb.getDriver().findElements(By.cssSelector(name));
					} catch (Exception e3) {
						try {
							elemento = DriverWeb.getDriver().findElements(By.linkText(name));
						} catch (Exception e4) {
							try {
								elemento = DriverWeb.getDriver().findElements(By.partialLinkText(name));
							} catch (Exception e5) {
								try {
									elemento = DriverWeb.getDriver().findElements(By.tagName(name));
								} catch (Exception e6) {
									String valorError = "Nenhum elemento foi identificado!";
									System.out.println(valorError);
									throw new java.lang.Error(valorError);
								}
							}
						}
					}
				}
			}
		}
		return elemento;
	}

	public default boolean verificarElementExibido(String elemento) {
		System.out.println("verificando elemento.. " + elemento);
		if (encontra(elemento).isDisplayed()) {
			System.out.println("elemento verificado");
			return true;
		} else {
			System.out.println("elemento não encontrado");
			return false;
		}
	}

	public default boolean elementExiste(String name) {
		System.out.println("Verificando se elemento existe: " + name);
		boolean retorno = false;

		try {
			System.out.println("Procurando elemento por id...");
			DriverWeb.getDriver().findElement(By.id(name));
			retorno = true;
		} catch (Exception e) {
			try {
				System.out.println("Procurando elemento por xpath...");
				DriverWeb.getDriver().findElement(By.xpath(name));
				retorno = true;
			} catch (Exception e1) {

				try {
					System.out.println("Procurando elemento por name...");
					DriverWeb.getDriver().findElement(By.name(name));
					retorno = true;
				} catch (Exception e2) {

					try {
						System.out.println("Procurando elemento por css Selector...");
						DriverWeb.getDriver().findElement(By.cssSelector(name));
						retorno = true;
					} catch (Exception e3) {

						try {
							System.out.println("Procurando elemento por link text...");
							DriverWeb.getDriver().findElement(By.linkText(name));
							retorno = true;
						} catch (Exception e4) {

							try {
								System.out.println("Procurando elemento por partial link text...");
								DriverWeb.getDriver().findElement(By.partialLinkText(name));
								retorno = true;
							} catch (Exception e5) {

								try {
									System.out.println("Procurando elemento por tag Name...");
									DriverWeb.getDriver().findElement(By.tagName(name));
									retorno = true;
								} catch (Exception e6) {
									String valorError = "Nenhum elemento foi identificado!";
									System.out.println(valorError);

								}
							}
						}
					}
				}
			}
		}

		return retorno;
	}
}