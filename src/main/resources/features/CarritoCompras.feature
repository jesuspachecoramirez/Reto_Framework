# language: es

@FeatureName:CarritoCompras
Característica: Validar el carrito de compras
  Como cliente de la pagina
  necesito validar el carrito de compras
  para verificar si se registra la compra en el mismo


  @ScenarioName:CarritoCompras
  Escenario: Ingresar al Carrito de compras
    Dado Que el cliente esta en la pagina de inicio
    Cuando El cliente ingresa al carrito de compras
    Entonces como resultado el cliente puede observa el resumen del carrito

  @ScenarioName:AgregaItem
  Escenario: Agregar un item de la tienda al carrito
    Dado Que el cliente se encuentra en la pagina de inicio
    Cuando El cliente añade una prenda de la seccion popular al carrito
    Entonces como resultado el cliente valida el producto agregado al carrito