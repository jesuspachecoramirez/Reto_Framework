package com.yourlogo.webproject.test.controllers.opencreateacount;

import com.yourlogo.webproject.test.page.CreateAccount.MyAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.yourlogo.webproject.test.util.Timeoutkey;

public class MyAccountWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerNombreDeNuevoUsuario(){
        String usuario = "";
        try{
            MyAccountPage myAccountPage = new MyAccountPage(webAction.getDriver());

            usuario = webAction.getText(myAccountPage.getCustomerName(), Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la creación de un cuenta.", e);
        }

        return usuario;
    }
}
