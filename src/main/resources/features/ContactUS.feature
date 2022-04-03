# language: es

@FeatureName:Contactenos
  Característica: Validar las funciones de la seccion Contact US
    Como cliente de la pagina web yourlogo
    necesito realizar solicitudes a la tienda por diferentes razones
    para poder resolver problemas y dudas



    @ScenarioName:ServicioAlCliente
    Escenario:Mensaje a servicio al cliente
      Dado Que el cliente esta en la pagina de ContactUs
      Cuando Selecciona la opcion de Customer service
      Entonces llena los campos requeridos y envia el mensaje


    @EscenarioName:WebMaster
    Escenario: Mensaje para el Webmaster
      Dado Que el cliente se encuentra en la pagina de ContactUs
      Cuando Selecciona la opcion de Webmaster
      Entonces llena los campos requeridos anexa una prueba y envia el mensaje




