package com.pe.automation.pageojects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ResultadoPage extends PageObject{
	
	@FindBy(xpath="//span[contains(@class, 'cbx x-refine__multi-select-cbx') and text()='10']/preceding-sibling::input[@type='checkbox']")
	public WebElementFacade chkTalla; 
	
	@FindBy(xpath="//h1[contains(text(),'resultados')]")
	public WebElementFacade lblNroResultado;
	
	@FindBy(xpath="//div[text()='Mejor resultado']")
	public WebElementFacade cmbMejorResultado;
	
	@FindBy(xpath="//span[text()='Precio + Envío: más bajo primero']")
	public WebElementFacade precioAscendente;
	
	@FindBy(xpath="//div[@class='s-item__wrapper clearfix']//span[@class='s-item__price']")
	public List<WebElementFacade> listaPreciosProductos;
	
	@FindBy(xpath="//div[@class='s-item__wrapper clearfix']//h3[@class='s-item__title']")
	public List<WebElementFacade> listaNombresProductos;
	
	private static Logger LOGGER = LoggerFactory.getLogger(ResultadoPage.class);
	
	public void seleccionarTalla(String strTalla) {	
	//	WebElementFacade element = chkTalla.find(By.xpath("//span[contains(@class,'cbx x-refine__multi-select-cbx') and text()='"+strTalla+"']/preceding-sibling::input[@type='checkbox']"));
		chkTalla.click();
	}
	
	public void obtenerNumeroResultado() {
		String lbl = lblNroResultado.getText();
		String[] parts = lbl.split(" ");
		LOGGER.info("Total de resultado: "+parts[0]);
	}
	
	public void ordernarPorPrecioAscendente() {
		 Actions actions = new Actions(getDriver());
		 actions.moveToElement(cmbMejorResultado).build().perform();
		 actions.moveToElement(precioAscendente).perform();
		 precioAscendente.click();
	}
	
	public void realizarPedidoDeProductos(String strCantidad) {
		int can = Integer.parseInt(strCantidad);
		LOGGER.info("PEDIDO:");
		for (int i = 0; i < can ; i++) {
			LOGGER.info(listaNombresProductos.get(i).getText() +" - "+ listaPreciosProductos.get(i).getText());
		}
	}
	
	public void obtenerProductosPorPrecios(String strCantidad) {
		LOGGER.info("PRODUCTOS Y PRECIOS:");
		int can = Integer.parseInt(strCantidad);
		for (int i = 0; i < can ; i++) {
			LOGGER.info(listaNombresProductos.get(i).getText() +" - "+ listaPreciosProductos.get(i).getText());
		}
	}
	
	public void listarProductosPorNombreAscendente() {
		LOGGER.info("PRODUCTOS ORDENADOS POR NOMBRES ASCENDENTE:");
		ArrayList<String> listaNombres = new ArrayList<String>();
		for (int i = 0; i < listaNombresProductos.size() ; i++) {
			listaNombres.add(listaNombresProductos.get(i).getText());
		}
		Collections.sort(listaNombres);
		for (int i = 0; i < 30 ; i++) {// para no mostrar todos los productos
			LOGGER.info(listaNombres.get(i));
		}
	}
	
	public void listarProductosPorPrecioDescendente() {
		LOGGER.info("PRODUCTOS ORDENADOS POR PRECIOS DESCENDENTE:");
		HashMap<String, Double> unSortedMap = new HashMap<>();
		String lblPrecio;
		String[] parts;
		for (int i = 0; i < listaNombresProductos.size() ; i++) {
			lblPrecio = listaPreciosProductos.get(i).getText();
			parts = lblPrecio.split(" ");
			unSortedMap.put(listaNombresProductos.get(i).getText(), Double.parseDouble(parts[1]));
		}
		LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();
		unSortedMap.entrySet()
		    .stream()
		    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

		System.out.println(sortedMap);
	}	

}
