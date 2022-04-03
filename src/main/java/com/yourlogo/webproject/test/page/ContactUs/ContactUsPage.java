package com.yourlogo.webproject.test.page.ContactUs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @CacheLookup
    @FindBy(id = "uniform-id_contact")
    WebElement contactar;

    @CacheLookup
    @FindBy(id = "id_contact")
    WebElement customservice;

    @CacheLookup
    @FindBy(id = "email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "id_order")
    WebElement orden;

    @CacheLookup
    @FindBy(id = "message")
    WebElement mensaje;

    @CacheLookup
    @FindBy(id = "submitMessage")
    WebElement enviar;

    @CacheLookup
    @FindBy(css = ".alert-success")
    WebElement exito;

    @CacheLookup
    @FindBy(id = "fileUpload")
    WebElement subir;


    public WebElement getCustomservice(){
        return customservice;
    }

    public WebElement getContactar(){
        return contactar;
    }

    public WebElement getEmail(){return email;}

    public WebElement getOrden(){return orden;}

    public WebElement getMensaje(){return mensaje;}

    public WebElement getEnviar(){return enviar;}

    public WebElement getExito(){return exito;}

    public WebElement getSubir(){return subir;}


    public ContactUsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
