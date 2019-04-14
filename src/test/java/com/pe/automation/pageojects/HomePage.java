package com.pe.automation.pageojects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@DefaultUrl("https://www.ebay.com/")
public class HomePage extends PageObject{

	@FindBy(id="gh-ac")
	public WebElementFacade txtArticulo;
	
	@FindBy(id="gh-cat")
	public WebElementFacade cmbCategoria;
	
	@FindBy(id="gh-btn")
	public WebElementFacade btnBuscar; 
	
	@FindBy(xpath="/html[@class='font-marketsans']/body[@class='desktop gh-flex']/header[@id='gh']/div[@id='gh-top']/ul[@id='gh-topl']/li[@id='gh-p-1']/a[@class='gh-p']")
	public WebElementFacade lblHome;
	
	public void verificarHome() {
		String label = "ebay Ofertas";
		String strMensaje = lblHome.getText();
		assertThat(strMensaje, containsString(label));
	}
	
	public void ingresarNombreArticulo(String strArticulo) {
		txtArticulo.click();
		txtArticulo.clear();
		txtArticulo.sendKeys(strArticulo);
	}	
	
	public void seleccionarCategoria(String strCategoria) {
		cmbCategoria.click();
		cmbCategoria.selectByVisibleText(strCategoria);
	}

	public void buscarArticulo() {
		btnBuscar.click();		
	}	

}
