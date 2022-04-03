package com.yourlogo.webproject.test.controllers.opencontactus;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.yourlogo.webproject.test.helpers.Dictionary;
import com.yourlogo.webproject.test.helpers.Helper;
import com.yourlogo.webproject.test.model.Customer;
import com.yourlogo.webproject.test.page.ContactUs.ContactUsPage;
import com.yourlogo.webproject.test.util.Archivo;
import com.yourlogo.webproject.test.util.Timeoutkey;


public class ContactUsController {

    private WebAction webAction;
    private Customer customer;



    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void selectCustomerService(){

        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.scroll(300);
            webAction.click(contactUsPage.getContactar(), Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            webAction.selectByValue(contactUsPage.getCustomservice(), "2", true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error", e);
        }

    }

    public void addInformation(){

        try {
            customer = Helper.generateCustomer(Dictionary.SPANISH_CODE_LANGUAGE, Dictionary.COUNTRY_CODE, Dictionary.EMAIL_DOMAIN);

            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.sendText(contactUsPage.getEmail(),customer.getEmail(),
                    Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            webAction.sendText(contactUsPage.getOrden(),customer.getOrder(),
                    Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            webAction.sendText(contactUsPage.getMensaje(),customer.getPrueba(),
                    Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            webAction.click(contactUsPage.getEnviar(), Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error", e);
        }
    }

    public String confirmSend(){
        String confirm="";
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            confirm = webAction.getText(contactUsPage.getExito(),
                    Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);


        }catch(WebActionsException e){
            Report.reportFailure("Ocurrio un error", e);
        }
        return confirm;
    }

    public void selectWebmaster(){

        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.scroll(300);
            webAction.click(contactUsPage.getContactar(), Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            webAction.selectByValue(contactUsPage.getCustomservice(), "1", true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error", e);
        }

    }

    public void sendInformationplus(){

        try {
            customer = Helper.generateCustomer(Dictionary.SPANISH_CODE_LANGUAGE, Dictionary.COUNTRY_CODE, Dictionary.EMAIL_DOMAIN);


            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.sendText(contactUsPage.getEmail(),customer.getEmail(),
                    Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            webAction.sendText(contactUsPage.getOrden(),customer.getOrder(),
                    Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            webAction.sendText(contactUsPage.getMensaje(),customer.getPrueba(),
                    Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            Archivo archivo = new Archivo();
            webAction.uploadFile(contactUsPage.getSubir(),archivo.subirarchivo(),true);
            webAction.click(contactUsPage.getEnviar(), Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error", e);
        }

    }
}
