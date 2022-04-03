package com.yourlogo.webproject.test.controllers.openlogin;

import com.yourlogo.webproject.test.page.CreateAccount.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.yourlogo.webproject.test.util.Timeoutkey;

public class LoginPageController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void irHaciaLoginPage(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());

            webAction.click(landingPage.getSignIn(), Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar abrir la tienda online", e);
        }
    }

}
