@Regresion
Feature: Formulario para busqueda de articulos
  El usuario debe poder ingresar al formulario y realizar la busqueda de los articulos.
  
  @CasoExitoso
  Scenario: Como usuario, quiero realizar una busqueda de calzados.
    Given Ingreso a la pagina de ebay
    And la pagina carga correctamente    
    When selecciono la opcion de "Ropa, zapatos y accesorios"
    And la marca "puma"   
    And presionamos el boton de la busqueda
    And seleccionamos la talla del calzado "10"
    Then se imprime el numero de resultado
    And ordenamos por el precio ascendente
    And realizar el pedido tomando los primeros "5" resultados
    And tomar los primeros "5" productos con sus precios
    And imprimir los productos por nombre ascendente
    And imprimir los productos por precio en modo descendiente