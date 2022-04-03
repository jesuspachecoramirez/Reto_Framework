package com.yourlogo.webproject.test.stepdefinition;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import com.yourlogo.webproject.test.controllers.opencontactus.ContactUsController;
import com.yourlogo.webproject.test.controllers.openwebpage.StartBrowserWebController;
import com.yourlogo.webproject.test.data.objects.TestInfo;
import com.yourlogo.webproject.test.util.Timeoutkey;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class ContactUsStepDefinition extends Setup {
    private WebAction webAction;
    ContactUsController contactUsController= new ContactUsController();



    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("Que el cliente esta en la pagina de ContactUs")
    public void queElClienteEstaEnLaPaginaDeContactUs() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirContactUs();

    }
    @Cuando("Selecciona la opcion de Customer service")
    public void seleccionaLaOpcionDeCustomerService() {

        contactUsController.setWebAction(webAction);
        contactUsController.selectCustomerService();

    }
    @Entonces("llena los campos requeridos y envia el mensaje")
    public void llenaLosCamposRequeridosYEnviaElMensaje() {

        contactUsController.setWebAction(webAction);
        contactUsController.addInformation();
        String confirm= contactUsController.confirmSend();

        Assert
                .Hard
                .thatString(confirm);

    }

    @Dado("Que el cliente se encuentra en la pagina de ContactUs")
    public void queElClienteSeEncuentraEnLaPaginaDeContactUs() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirContactUs();
    }

    @Cuando("Selecciona la opcion de Webmaster")
    public void seleccionaLaOpcionDeWebmaster() {

        contactUsController.setWebAction(webAction);
        contactUsController.selectWebmaster();


    }
    @Entonces("llena los campos requeridos anexa una prueba y envia el mensaje")
    public void llenaLosCamposRequeridosAnexaUnaPruebaYEnviaElMensaje() {

        contactUsController.setWebAction(webAction);
        contactUsController.sendInformationplus();
        String confirm= contactUsController.confirmSend();

        Assert
                .Hard
                .thatString(confirm);

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
