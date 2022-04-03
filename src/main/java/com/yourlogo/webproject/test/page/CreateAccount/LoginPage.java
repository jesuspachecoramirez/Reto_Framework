package com.yourlogo.webproject.test.page.CreateAccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @CacheLookup
    @FindBy(id= "email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "passwd")
    WebElement password;

    @CacheLookup
    @FindBy(id = "SubmitLogin")
    WebElement SubmitLogin;



}
