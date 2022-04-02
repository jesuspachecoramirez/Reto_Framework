package com.yourlogo.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitialPage {

    @CacheLookup
    @FindBy(css = ".product_img_link")
     WebElement prenda;

    @CacheLookup
    @FindBy(css = ".ajax_add_to_cart_button")
   WebElement agregar;

    @CacheLookup
    @FindBy(css = ".button-medium")
    WebElement cierre;

    @CacheLookup
    @FindBy(id = "product_1_1_0_0")
    WebElement compra;

    public InitialPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getCompra(){
        return compra;
    }

    public WebElement getPrenda() {
        return prenda;
    }

    public WebElement getCierre() {
        return cierre;
    }

    public WebElement getAgregar() {
        return agregar;
    }
}
