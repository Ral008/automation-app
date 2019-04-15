package com.pe.automation.definition;

import com.pe.automation.steps.BuyerSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ArticuloDefinition {
	
	@Steps
	BuyerSteps buyerSteps;

	@Given("^Ingreso a la pagina de ebay$")
	public void ingreso_a_la_pagina_de_ebay() throws Throwable {
		buyerSteps.open_home_page();
	}

	@Given("^la pagina carga correctamente$")
	public void la_pagina_carga_correctamente() throws Throwable {
		buyerSteps.verificar_home();
	}

	@When("^selecciono la opcion de \"([^\"]*)\"$")
	public void selecciono_la_opcion_de(String categoria) throws Throwable {
		buyerSteps.seleccionar_categoria(categoria);
	}

	@When("^la marca \"([^\"]*)\"$")
	public void la_marca(String marca) throws Throwable {
		buyerSteps.ingresar_nombre_articulo(marca);
	}

	@When("^presionamos el boton de la busqueda$")
	public void presionamos_el_boton_de_la_busqueda() throws Throwable {
		buyerSteps.buscar_articulo();
	}

	@When("^seleccionamos la talla del calzado \"([^\"]*)\"$")
	public void seleccionamos_la_talla_del_calzado(String talla) throws Throwable {
		buyerSteps.seleccionar_talla(talla);
	}

	@Then("^se imprime el numero de resultado$")
	public void se_imprime_el_numero_de_resultado() throws Throwable {
		buyerSteps.obtener_numero_resultado();
	}

	@Then("^ordenamos por el precio ascendente$")
	public void ordenamos_por_el_precio_ascendente() throws Throwable {
		buyerSteps.ordernar_por_precio_ascendente();
	}
	
	@Then("^realizar el pedido tomando los primeros \"([^\"]*)\" resultados$")
	public void realizar_el_pedido_tomando_los_primeros_resultados(String cantidad) throws Throwable {
		buyerSteps.realizar_pedido_de_productos(cantidad);
	}

	@Then("^tomar los primeros \"([^\"]*)\" productos con sus precios$")
	public void tomar_los_primeros_productos_con_sus_precios(String cantidad) throws Throwable {
		buyerSteps.obtener_productos_por_precios(cantidad);
	}

	@Then("^imprimir los productos por nombre ascendente$")
	public void imprimir_los_productos_por_nombre_ascendente() throws Throwable {
		buyerSteps.listar_productos_por_nombre_ascendente();
	}

	@Then("^imprimir los productos por precio en modo descendiente$")
	public void imprimir_los_productos_por_precio_en_modo_descendiente() throws Throwable {
		buyerSteps.listar_productos_por_precio_descendente();
	}

}
