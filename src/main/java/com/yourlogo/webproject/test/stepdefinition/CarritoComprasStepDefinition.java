package com.yourlogo.webproject.test.stepdefinition;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import com.yourlogo.webproject.test.controllers.openshoppingcart.ShoppinCartWebController;
import com.yourlogo.webproject.test.controllers.openwebpage.StartBrowserWebController;
import com.yourlogo.webproject.test.data.objects.TestInfo;
import com.yourlogo.webproject.test.util.Timeoutkey;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class CarritoComprasStepDefinition extends Setup {

    private WebAction webAction;
    ShoppinCartWebController shoppinCartWebController = new ShoppinCartWebController();

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }


    @Dado("Que el cliente esta en la pagina de inicio")
    public void queElClienteEstaEnLaPaginaDeInicio() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

    }
    @Cuando("El cliente ingresa al carrito de compras")
    public void elClienteIngresaAlCarritoDeCompras() {

        ShoppinCartWebController shoppinCartWebController = new ShoppinCartWebController();
        shoppinCartWebController.setWebAction(webAction);
        shoppinCartWebController.CarritoCompras();

    }
    @Entonces("como resultado el cliente puede observa el resumen del carrito")
    public void comoResultadoElClientePuedeObservaElResumenDelCarrito() {

        shoppinCartWebController.setWebAction(webAction);
        String carrito= shoppinCartWebController.iniciocart();

        Assert
                .Hard
                .thatString(carrito);
    }

    @Dado("Que el cliente se encuentra en la pagina de inicio")
    public void queElClienteSeEncuentraEnLaPaginaDeInicio() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();


    }

    @Cuando("El cliente añade una prenda de la seccion popular al carrito")
    public void elClienteAñadeUnaPrendaDeLaSeccionPopularAlCarrito() {
        ShoppinCartWebController shoppinCartWebController = new ShoppinCartWebController();
        shoppinCartWebController.setWebAction(webAction);
        shoppinCartWebController.compra();

    }

    @Entonces("como resultado el cliente valida el producto agregado al carrito")
    public void comoResultadoElClienteValidaElProductoAgregadoAlCarrito() {

        shoppinCartWebController.setWebAction(webAction);
        String compra = shoppinCartWebController.comprañadida();

        Assert
                .Hard
                .thatString(compra);
    }


    @After
    public void cerrarDriver() throws InterruptedException {

        Thread.sleep(Timeoutkey.TIME_SLEEP_RESOURCE.getValue());

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }




}
