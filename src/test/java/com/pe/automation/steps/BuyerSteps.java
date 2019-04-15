package com.pe.automation.steps;

import com.pe.automation.pageojects.HomePage;
import com.pe.automation.pageojects.ResultadoPage;

import net.thucydides.core.annotations.Step;

public class BuyerSteps {
	HomePage homePage;
	ResultadoPage resultadoPage;
	
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
	
	@Step
	public void seleccionar_talla(String strTalla) {
		resultadoPage.seleccionarTalla(strTalla);
	}
	
	@Step
	public void obtener_numero_resultado() {
		resultadoPage.obtenerNumeroResultado();
	}
	
	@Step
	public void ordernar_por_precio_ascendente() {
		resultadoPage.ordernarPorPrecioAscendente();
	}
	
	@Step
	public void obtener_productos_por_precios(String strCantidad) {
		resultadoPage.obtenerProductosPorPrecios(strCantidad);
	}
	
	@Step
	public void realizar_pedido_de_productos(String strCantidad) {
		resultadoPage.realizarPedidoDeProductos(strCantidad);
	}
	
	@Step
	public void listar_productos_por_nombre_ascendente() {
		resultadoPage.listarProductosPorNombreAscendente();
	}
	
	@Step
	public void listar_productos_por_precio_descendente() {
		resultadoPage.listarProductosPorPrecioDescendente();
	}
	
}
