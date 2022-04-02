package com.yourlogo.webproject.test.controllers.opencreateacount;

import com.yourlogo.webproject.test.model.Customer;
import com.yourlogo.webproject.test.page.CreateAnAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.yourlogo.webproject.test.util.Timeoutkey;
import com.yourlogo.webproject.test.helpers.Dictionary;
import com.yourlogo.webproject.test.helpers.Helper;

public class CreateAnAccountWebController {
    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void crearUnaCuenta(){
        try{
            customer = Helper.generateCustomer(Dictionary.SPANISH_CODE_LANGUAGE, Dictionary.COUNTRY_CODE, Dictionary.EMAIL_DOMAIN);

            CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());

            webAction.sendText(
                    createAnAccountPage.getEmailAddress(),
                    customer.getEmail(),
                    Timeoutkey.TIME_OUT_RESOURCE.getValue(),
                    true
            );
            webAction.click(createAnAccountPage.getCreateAnAccount(), Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            webAction.click(createAnAccountPage.getMr(), Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            webAction.sendText(createAnAccountPage.getFirstName(), customer.getFirstName(), true);
            webAction.sendText(createAnAccountPage.getLastName(), customer.getLastName(), true);
            webAction.sendText(createAnAccountPage.getPassword(), customer.getPassword(), true);
            webAction.selectByPartialText(createAnAccountPage.getDay(), customer.getDayBirth(), true);
            webAction.selectByValue(createAnAccountPage.getMonth(), customer.getMonthBirth(), true);
            webAction.selectByPartialText(createAnAccountPage.getYear(), customer.getYearBirth(), true);
            webAction.sendText(createAnAccountPage.getAddress1(), customer.getAddress(), true);
            webAction.sendText(createAnAccountPage.getCity(), customer.getCity(), true);
            webAction.selectByText(createAnAccountPage.getState(), customer.getState(), true);
            webAction.sendText(createAnAccountPage.getPostCode(), customer.getPostalCode(), true);
            webAction.sendText(createAnAccountPage.getPhoneMobile(), customer.getMobilePhone(), true);
            webAction.click(createAnAccountPage.getRegister(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar crear una cuenta.", e);
        }
    }
}
