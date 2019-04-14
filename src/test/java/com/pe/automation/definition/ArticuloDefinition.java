package com.pe.automation.definition;

import com.pe.automation.steps.BuyerSteps;

import cucumber.api.PendingException;
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
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
