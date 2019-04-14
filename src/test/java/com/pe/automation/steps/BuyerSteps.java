package com.pe.automation.steps;

import com.pe.automation.pageojects.HomePage;
import net.thucydides.core.annotations.Step;

public class BuyerSteps {
	HomePage homePage;
	
	@Step
	public void open_home_page() {
		homePage.open();		
	}
	
	@Step
	public void verificar_home() {		
		homePage.verificarHome();
	}
	
	@Step
	public void ingresar_nombre_articulo(String strArticulo) {
		homePage.ingresarNombreArticulo(strArticulo);
	}
	
	@Step
	public void seleccionar_categoria(String strCategoria) {
		homePage.seleccionarCategoria(strCategoria);
	}
	
	@Step
	public void buscar_articulo() {
		homePage.buscarArticulo();
	}
	
}
