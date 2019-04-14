package com.pe.automation.pageojects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ResultadoPage extends PageObject{
	
	public WebElementFacade chkTalla; 
	
	@FindBy(xpath="//h1[contains(text(),'resultados')]")
	public WebElementFacade lblNroResultado;
	
	private static Logger LOGGER = LoggerFactory.getLogger(ResultadoPage.class);
	
	public void seleccionarTalla(String strTalla) throws InterruptedException {	
		Thread.sleep(5000);
		WebElementFacade element = chkTalla.find(By.xpath("//span[contains(@class,'cbx x-refine__multi-select-cbx') and text()='"+strTalla+"']/preceding-sibling::input[@type='checkbox']"));
		element.click();
	}
	
	public void obtenerNumeroResultado() {
		String lbl = lblNroResultado.getText();
		String[] parts = lbl.split(" ");
		LOGGER.info("Total de resultado: "+parts[0]);
	}
	
	

}
