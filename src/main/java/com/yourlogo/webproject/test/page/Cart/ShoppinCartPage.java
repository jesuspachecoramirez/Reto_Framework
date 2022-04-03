package com.yourlogo.webproject.test.page.Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppinCartPage {
    @CacheLookup
    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=order']")
    WebElement className;


    @CacheLookup
    @FindBy(id = "cart_title")
    WebElement Cart;


    public ShoppinCartPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }


    public WebElement getClassName() {
        return className;
    }

    public WebElement getCart() {
        return Cart;
    }
}
