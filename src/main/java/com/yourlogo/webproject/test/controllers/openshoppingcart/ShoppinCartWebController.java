package com.yourlogo.webproject.test.controllers.openshoppingcart;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.yourlogo.webproject.test.page.InitialPage;
import com.yourlogo.webproject.test.page.ShoppinCartPage;
import com.yourlogo.webproject.test.util.Timeoutkey;

public class ShoppinCartWebController {
   private WebAction webAction;



    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void CarritoCompras(){
        try{
            ShoppinCartPage shoppinCartPage = new ShoppinCartPage(webAction.getDriver());
            webAction.click(shoppinCartPage.getClassName(), Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error.", e);
        }

    }

    public String iniciocart(){
        String carrito="";
        try{
            ShoppinCartPage shoppinCartPage = new ShoppinCartPage(webAction.getDriver());
            carrito = webAction.getText(shoppinCartPage.getCart(),
                    Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error.", e);
        }
        return carrito;
    }

    public void compra(){
        try{
            InitialPage initialPage = new InitialPage(webAction.getDriver());
            webAction.scroll(800);
            webAction.moveTo(initialPage.getPrenda(),Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            webAction.click(initialPage.getAgregar(),Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);
            webAction.click(initialPage.getCierre(), Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error.", e);
        }

    }

    public String comprañadida(){
        String compra="";
        try{
            InitialPage initialPage = new InitialPage(webAction.getDriver());
            webAction.scroll(200);
            webAction.getText(initialPage.getCompra(), Timeoutkey.TIME_OUT_RESOURCE.getValue(), true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error.", e);
        }
        return compra;
    }


}
